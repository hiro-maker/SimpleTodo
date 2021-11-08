package com.hiromaker.simpletodo.data.model


/**
 * 一つのタスクのデータモデル.
 */
data class Task(
    val icon: String,
    val title: String,
    val description: String,
    val startTime: String,
    val endTime: String,
    val isRemind: Boolean,
    val term: Int,
    val priority: Int,
    val isSuccess: Boolean,
    val tags: Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Task

        if (icon != other.icon) return false
        if (title != other.title) return false
        if (description != other.description) return false
        if (startTime != other.startTime) return false
        if (endTime != other.endTime) return false
        if (isRemind != other.isRemind) return false
        if (term != other.term) return false
        if (priority != other.priority) return false
        if (isSuccess != other.isSuccess) return false
        if (!tags.contentEquals(other.tags)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = icon.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + startTime.hashCode()
        result = 31 * result + endTime.hashCode()
        result = 31 * result + isRemind.hashCode()
        result = 31 * result + term
        result = 31 * result + priority
        result = 31 * result + isSuccess.hashCode()
        result = 31 * result + tags.contentHashCode()
        return result
    }

}