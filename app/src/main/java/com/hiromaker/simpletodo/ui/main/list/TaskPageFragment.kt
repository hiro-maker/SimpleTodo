package com.hiromaker.simpletodo.ui.main.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hiromaker.simpletodo.R
import com.hiromaker.simpletodo.util.Term


class TaskPageFragment(private val term: Term) : Fragment() {

    private val viewModel by viewModels<TaskViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.task_page_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val taskListView = view.findViewById<RecyclerView>(R.id.task_list)

        viewModel.getTaskList(term.ordinal).observe(viewLifecycleOwner) { list ->
            taskListView.layoutManager = LinearLayoutManager(context)
            taskListView.adapter = TaskRecyclerViewAdapter(list.filter { it.term == term.ordinal })
        }

        // リストのユーザアクション(順序の入替&スワイプ削除).
        val mIth = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, ItemTouchHelper.LEFT) {

            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                val fromPos = viewHolder.adapterPosition
                val toPos = target.adapterPosition
                (taskListView.adapter as TaskRecyclerViewAdapter).let {
                    viewModel.moveTask(
                        it.getItem(fromPos),
                        it.getItem(toPos)
                    )
                }
                taskListView.adapter?.notifyItemMoved(fromPos, toPos)
                return true // true if moved, false otherwise
            }

            override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
                return makeMovementFlags(
                    ItemTouchHelper.UP or ItemTouchHelper.DOWN,
                    ItemTouchHelper.LEFT
                )
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                    //データリストからスワイプしたデータを削除
//                    dataList.removeAt(viewHolder.adapterPosition)
                //リストからスワイプしたカードを削除
                taskListView.adapter?.notifyItemRemoved(viewHolder.layoutPosition)

                // FIXME 直DAO呼び出し法
                (taskListView.adapter as TaskRecyclerViewAdapter).getItem(viewHolder.layoutPosition).let {
                    viewModel.deleteTask(it)
                }
            }

            override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
                super.clearView(recyclerView, viewHolder)
                (taskListView.adapter as TaskRecyclerViewAdapter).let {
                    viewModel.updateTaskList(it.getItemList())
                }
            }
        })
        mIth.attachToRecyclerView(taskListView)
    }
}