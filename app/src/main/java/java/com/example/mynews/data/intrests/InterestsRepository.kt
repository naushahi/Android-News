package java.com.example.mynews.data.intrests

import kotlinx.coroutines.flow.Flow
import java.com.example.mynews.data.Result

data class InterestsSection(val title: String, val interests: List<String>)

interface InterestsRepository {
    suspend fun getTopics(): Result<List<InterestsSection>>
    suspend fun getPeople(): Result<List<String>>
    suspend fun getPublications(): Result<List<String>>
    suspend fun toggleTopicSelection(topic: TopicSelection)
    suspend fun togglePersonSelected(person: String)
    suspend fun togglePublicationSelected(publication: String)
    fun observeTopicsSelected(): Flow<Set<TopicSelection>>
    fun observePeopleSelected(): Flow<Set<String>>
    fun observePublicationSelected(): Flow<Set<String>>
}

data class TopicSelection(val section: String, val topic: String)