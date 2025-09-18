package java.com.example.mynews.data.intrests.impl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import java.com.example.mynews.data.Result
import java.com.example.mynews.data.intrests.InterestsRepository
import java.com.example.mynews.data.intrests.InterestsSection
import java.com.example.mynews.data.intrests.TopicSelection
import java.com.example.mynews.utils.addOrRemove

@OptIn(ExperimentalCoroutinesApi::class)
class FakeInterestsRepository: InterestsRepository {

    private val topics by lazy {
        listOf(
            InterestsSection("Android", listOf("Jetpack Compose", "Kotlin", "Jetpack")),
            InterestsSection("Programming", listOf("Kotlin", "Declarative UIs", "Java", "Unidirectional Data Flow", "C++")),
            InterestsSection("Technology", listOf("Pixel", "Google"))
        )
    }

    private val people by lazy {
        listOf(
            "Kobalt Toral",
            "K'Kola Uvarek",
            "Kris Vriloc",
            "Grala Valdyr",
            "Kruel Valaxar",
            "L'Elij Venonn",
            "Kraag Solazarn",
            "Tava Targesh",
            "Kemarrin Muuda",
        )
    }

    private val publications by lazy {
        listOf(
            "Kotlin Vibe",
            "Compose Mix",
            "Compose Breakdown",
            "Android Pursue",
            "Kotlin Watchman",
            "Jetpack Ark",
            "Composeshack",
            "Jetpack Point",
            "Compose Tribune",
        )
    }

    private val selectedTopics = MutableStateFlow(setOf<TopicSelection>())
    private val selectedPeople = MutableStateFlow(setOf<String>())
    private val selectedPublications = MutableStateFlow(setOf<String>())

    override suspend fun getTopics(): Result<List<InterestsSection>> {
        return Result.Success(topics)
    }

    override suspend fun getPeople(): Result<List<String>> {
        return Result.Success(people)
    }

    override suspend fun getPublications(): Result<List<String>> {
        return Result.Success(publications)
    }

    override suspend fun toggleTopicSelection(topic: TopicSelection) {
        selectedTopics.update {
            it.addOrRemove(topic)
        }
    }

    override suspend fun togglePersonSelected(person: String) {
        selectedPeople.update {
            it.addOrRemove(person)
        }
    }

    override suspend fun togglePublicationSelected(publication: String) {
        selectedPublications.update {
            it.addOrRemove(publication)
        }
    }

    override fun observeTopicsSelected(): Flow<Set<TopicSelection>> = selectedTopics
    override fun observePeopleSelected(): Flow<Set<String>>  = selectedPeople
    override fun observePublicationSelected(): Flow<Set<String>> = selectedPublications

}