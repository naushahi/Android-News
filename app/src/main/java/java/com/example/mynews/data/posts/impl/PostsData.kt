package java.com.example.mynews.data.posts.impl

import com.example.mynews.R
import java.com.example.mynews.model.Markup
import java.com.example.mynews.model.MarkupType
import java.com.example.mynews.model.Paragraph
import java.com.example.mynews.model.ParagraphType
import java.com.example.mynews.model.Post
import java.com.example.mynews.model.PostAuthor
import java.com.example.mynews.model.Publication
import java.com.example.mynews.model.Metadata
import java.com.example.mynews.model.PostFeed


val pietro = PostAuthor("Pietro Maggi", "https://medium.com/@pmaggi")
val manuel = PostAuthor("Manuel Vivo Vivo", "https://medium.com/@manuelvicnt")
val florina  = PostAuthor("Florina Muntenescu", "https://medium.com/@florina.muntenescu")
val jose = PostAuthor("Jose Alcérreca", "https://medium.com/@florina.muntenescu")
val androidStudioTeam = PostAuthor("The Android Studio team", "https://twitter.com/androidstudio")
val publication = Publication(
    name = "Android Developers",
    "https://cdn-images-1.medium.com/max/258/1*u7oZc2_5mrkcFaxkXEyfYA@2x.png")
val paragraphsPost1 = listOf(
    Paragraph(
        ParagraphType.TEXT,
        "In my efforts to enhance the modularity of our Android application, I created a sample that showcased a collection of on-demand features organized within a dedicated folder:"
    ),
    Paragraph(
        ParagraphType.TEXT,
        "A straightforward setup with all on-demand modules organized within a 'features' folder—simple and tidy."
    ),
    Paragraph(
        ParagraphType.TEXT,
        "These modules are incorporated in the settings.gradle file as follows:"
    ),
    Paragraph(
        ParagraphType.CODE_BLOCK,
        "include ':app'\n" +
                "include ':features:module1'\n" +
                "include ':features:module2'\n" +
                "include ':features:module3'\n" +
                "include ':features:module4'",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "This setup functions well, with just one minor issue: an empty module called 'features' appearing in the Android view in Android Studio."
    ),
    Paragraph(
        ParagraphType.TEXT,
        "I'm okay with that, but I'd much rather eliminate the empty module from my project!"
    ),
    Paragraph(
        ParagraphType.HEADER,
        "At I/O, I had the opportunity to attend the 'Android Studio: Tips and Tricks' session, where Ivan Gravilovic from Google shared some fantastic insights. One of his suggestions was a potential solution for my issue: setting a custom path for my modules.",
        listOf(
            Markup(
                MarkupType.ITALIC,
                41,
                72,
            ),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "In this particular case our settings.gradle becomes:",
        listOf(Markup(MarkupType.CODE, 28, 43)),
        ),
    Paragraph(
        ParagraphType.CODE_BLOCK,
        """
                include ':app'
                include ':module1'
                include ':module1'
                include ':module1'
                include ':module1'
                """.trimIndent(),
    ),
    Paragraph(
        ParagraphType.CODE_BLOCK,
        """
        project(":module1").projectDir=new File(rootDir, "features/module1")
        project(":module2").projectDir=new File(rootDir, "features/module2")
        project(":module3").projectDir=new File(rootDir, "features/module3")
        project(":module4").projectDir=new File(rootDir, "features/module4")
        """.trimIndent(),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "And the layout in Android Studio is now:",
    ),
    Paragraph(
        ParagraphType.HEADER,
        "Conclusion",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "As the title suggests, this is a minor detail, but it helps maintain order in my project and demonstrates how a simple Gradle configuration can keep things tidy."
    ),
    Paragraph(ParagraphType.QUOTE,
        "You can find this update in the latest version of the on-demand modules codelab.",
        listOf(
            Markup(
            MarkupType.LINK,
            54,
            79,
            "https://codelabs.developers.google.com/codelabs/on-demand-dynamic-delivery/index.html",
            ),
            ),
        ),
    Paragraph(
        ParagraphType.BULLET,
        "On Demand module codelab",
        listOf(
            Markup(
                MarkupType.LINK,
                0,
                24,
                "https://codelabs.developers.google.com/codelabs/on-demand-dynamic-delivery/index.html"
            ),
        ),
    ),
    Paragraph(
        ParagraphType.BULLET,
        "Patchwork Plaid — A modularization story",
        listOf(
            Markup(
                MarkupType.LINK,
                0,
                40,
                "https://medium.com/androiddevelopers/a-patchwork-plaid-monolith-to-modularized-app-60235d9f212e"
            ),
        ),
    ),
)

val paragraphsPost2 = listOf(
    Paragraph(
        ParagraphType.TEXT,
        "Dagger is a widely used Dependency Injection framework in Android. It offers fully static and compile-time dependencies, effectively addressing many development and performance challenges associated with reflection-based solutions.",
        listOf(
            Markup(
                MarkupType.LINK,
                0,
                6,
                "https://dagger.dev/",
            ),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "This month, a new tutorial was released to enhance your understanding of how it works. This article focuses on using Dagger with Kotlin, highlighting best practices to optimize build time and potential pitfalls you may encounter.",
        listOf(
            Markup(
                MarkupType.LINK,
                14,
                26,
                "https://dagger.dev/tutorial/",
            ),
            Markup(MarkupType.BOLD, 114, 132),
            Markup(MarkupType.BOLD, 144, 159),
            Markup(MarkupType.BOLD, 191, 198),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Dagger is built using Java’s annotations model, but Kotlin annotations don't always align perfectly with their Java counterparts. This post will highlight the differences and show you how to use Dagger with Kotlin smoothly.",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "This post was inspired by suggestions from a Dagger issue discussing best practices and challenges of using Dagger in Kotlin. Thanks to all the contributors who shared their insights!",
        listOf(
            Markup(
                MarkupType.LINK,
                58,
                70,
                "https://github.com/google/dagger/issues/900",
            ),
        ),
    ),
    Paragraph(
        ParagraphType.HEADER,
        "kapt build improvements",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "To enhance your build time, Dagger introduced support for Gradle's incremental annotation processing in v2.18! This feature is enabled by default in Dagger v2.24. If you're using an earlier version, you'll need to add a few lines of code (as shown below) to take advantage of it.",
        listOf(
            Markup(
                MarkupType.LINK,
                99,
                104,
                "https://github.com/google/dagger/releases/tag/dagger-2.18",
            ),
            Markup(
                MarkupType.LINK,
                143,
                148,
                "https://github.com/google/dagger/releases/tag/dagger-2.24",
            ),
            Markup(MarkupType.BOLD, 53, 95),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "You can also instruct Dagger not to format the generated code. This option was introduced in Dagger v2.18 and became the default behavior (non-formatted code) in v2.23. If you're using an earlier version, disable code formatting to enhance your build time (see code below).",
        listOf(
            Markup(
                MarkupType.LINK,
                92,
                97,
                "https://github.com/google/dagger/releases/tag/dagger-2.18",
            ),
            Markup(
                MarkupType.LINK,
                165,
                170,
                "https://github.com/google/dagger/releases/tag/dagger-2.23",
            ),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Include these compiler arguments in your build.gradle file to make Dagger more performant at build time:",
        listOf(Markup(MarkupType.CODE, 41, 53)),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Alternatively, if you use Kotlin DSL script files, include them like this in the build.gradle.kts file of the modules that use Dagger:",
        listOf(Markup(MarkupType.CODE, 81, 97)),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Qualifiers for field attributes",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "",
        listOf(Markup(MarkupType.LINK, 0, 0)),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "When an annotation is applied to a property in Kotlin, it can be unclear whether Java will recognize it on the field or the getter method for that property. Using the field: prefix on the annotation ensures that the qualifier is applied correctly (see the documentation for more details).",
        listOf(
            Markup(MarkupType.CODE, 181, 187),
            Markup(
                MarkupType.LINK,
                268,
                285,
                "http://frogermcs.github.io/dependency-injection-with-dagger-2-custom-scopes/",
            ),
            Markup(MarkupType.ITALIC, 114, 119),
            Markup(MarkupType.ITALIC, 143, 149),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "✅ The way to apply qualifiers on an injected field is:",
    ),
    Paragraph(
        ParagraphType.CODE_BLOCK,
        "@Inject @field:MinimumBalance lateinit var minimumBalance: BigDecimal",
        listOf(Markup(MarkupType.BOLD, 8, 29)),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "❌ As opposed to:",
    ),
    Paragraph(
        ParagraphType.CODE_BLOCK,
        """
        @Inject @MinimumBalance lateinit var minimumBalance: BigDecimal 
        // @MinimumBalance is ignored!
        """.trimIndent(),
        listOf(Markup(MarkupType.BOLD, 65, 95)),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Forgetting to add field: could lead to injecting the wrong object if there’s an unqualified instance of that type available in the Dagger graph.",
        listOf(Markup(MarkupType.CODE, 18, 24)),
    ),
    Paragraph(
        ParagraphType.HEADER,
        "Static @Provides functions optimization",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Dagger’s generated code will be more performant if @Provides methods are static. To achieve this in Kotlin, use a Kotlin object instead of a class and annotate your methods with @JvmStatic. This is a best practice that you should follow as much as possible.",
        listOf(
            Markup(MarkupType.CODE, 51, 60),
            Markup(MarkupType.CODE, 73, 79),
            Markup(MarkupType.CODE, 121, 127),
            Markup(MarkupType.CODE, 141, 146),
            Markup(MarkupType.CODE, 178, 188),
            Markup(MarkupType.BOLD, 200, 213),
            Markup(MarkupType.ITALIC, 200, 213),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "In case you need an abstract method, you’ll need to add the @JvmStatic method to a companion object and annotate it with @Module too.",
        listOf(
            Markup(MarkupType.CODE, 60, 70),
            Markup(MarkupType.CODE, 121, 128),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Alternatively, you can extract the object module out and include it in the abstract one:",
    ),
    Paragraph(
        ParagraphType.HEADER,
        "Injecting Generics",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Kotlin compiles generics with wildcards to make Kotlin APIs work with Java. These are generated when a type appears as a parameter (more info here) or as fields. For example, a Kotlin List<Foo> parameter shows up as List<? super Foo> in Java.",
        listOf(
            Markup(MarkupType.CODE, 184, 193),
            Markup(MarkupType.CODE, 216, 233),
            Markup(
                MarkupType.LINK,
                132,
                146,
                "https://kotlinlang.org/docs/reference/java-to-kotlin-interop.html#variant-generics",
            ),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "This causes problems with Dagger because it expects an exact (aka invariant) type match. Using @JvmSuppressWildcards will ensure that Dagger sees the type without wildcards.",
        listOf(
            Markup(MarkupType.CODE, 95, 116),
            Markup(
                MarkupType.LINK,
                66,
                75,
                "https://en.wikipedia.org/wiki/Class_invariant",
            ),
            Markup(
                MarkupType.LINK,
                96,
                116,
                "https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-suppress-wildcards/index.html",
            ),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "This is a common issue when you inject collections using Dagger’s multibinding feature, for example:",
        listOf(
            Markup(
                MarkupType.LINK,
                57,
                86,
                "https://dagger.dev/multibindings.html",
            ),
        ),
    ),
    Paragraph(
        ParagraphType.CODE_BLOCK,
        """
        class MyVMFactory @Inject constructor(
          private val vmMap: Map<String, @JvmSuppressWildcards Provider<ViewModel>>
        ) { 
            ... 
        }
        """.trimIndent(),
        listOf(Markup(MarkupType.BOLD, 72, 93)),
    ),
    Paragraph(
        ParagraphType.HEADER,
        "Inline method bodies",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Dagger determines the types that are configured by @Provides methods by inspecting the return type. Specifying the return type in Kotlin functions is optional and even the IDE sometimes encourages you to refactor your code to have inline method bodies that hide the return type declaration.",
        listOf(Markup(MarkupType.CODE, 51, 60)),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "This can lead to bugs if the inferred type is different from the one you meant. Let’s see some examples:",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "If you want to add a specific type to the graph, inlining works as expected. See the different ways to do the same in Kotlin:",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "If you want to provide an implementation of an interface, then you must explicitly specify the return type. Not doing it can lead to problems and bugs:",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Dagger mostly works with Kotlin out of the box. However, you have to watch out for a few things just to make sure you’re doing what you really mean to do: @field: for qualifiers on field attributes, inline method bodies, and @JvmSuppressWildcards when injecting collections.",
        listOf(
            Markup(MarkupType.CODE, 155, 162),
            Markup(MarkupType.CODE, 225, 246),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Dagger optimizations come with no cost, add them and follow best practices to improve your build time: enabling incremental annotation processing, disabling formatting and using static @Provides methods in your Dagger modules.",
        listOf(
            Markup(
                MarkupType.CODE,
                185,
                194,
            ),
        ),
    ),
)
val paragraphsPost3 = listOf(
    Paragraph(
        ParagraphType.TEXT,
        "Learn how to get started converting Java Programming Language code to Kotlin, making it more idiomatic and avoid common pitfalls, by following our new Refactoring to Kotlin codelab, available in English \uD83C\uDDEC\uD83C\uDDE7, Chinese \uD83C\uDDE8\uD83C\uDDF3 and Brazilian Portuguese \uD83C\uDDE7\uD83C\uDDF7.",
        listOf(
            Markup(
                MarkupType.LINK,
                151,
                172,
                "https://codelabs.developers.google.com/codelabs/java-to-kotlin/#0",
            ),
            Markup(
                MarkupType.LINK,
                209,
                216,
                "https://clmirror.storage.googleapis.com/codelabs/java-to-kotlin-zh/index.html#0",
            ),
            Markup(
                MarkupType.LINK,
                226,
                246,
                "https://codelabs.developers.google.com/codelabs/java-to-kotlin-pt-br/#0",
            ),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "When you first get started writing Kotlin code, you tend to follow Java Programming Language idioms. The automatic converter, part of both Android Studio and Intellij IDEA, can do a pretty good job of automatically refactoring your code, but sometimes, it needs a little help. This is where our new Refactoring to Kotlin codelab comes in.",
        listOf(
            Markup(
                MarkupType.LINK,
                105,
                124,
                "https://www.jetbrains.com/help/idea/converting-a-java-file-to-kotlin-file.html",
            ),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "We’ll take two classes (a User and a Repository) in Java Programming Language and convert them to Kotlin, check out what the automatic converter did and why. Then we go to the next level — make it idiomatic, teaching best practices and useful tips along the way.",
        listOf(
            Markup(MarkupType.CODE, 26, 30),
            Markup(MarkupType.CODE, 37, 47),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "The Refactoring to Kotlin codelab starts with basic topics — understand how nullability is declared in Kotlin, what types of equality are defined or how to best handle classes whose role is just to hold data. We then continue with how to handle static fields and functions in Kotlin and how to apply the Singleton pattern, with the help of one handy keyword: object. We’ll see how Kotlin helps us model our classes better, how it differentiates between a property of a class and an action the class can do. Finally, we’ll learn how to execute code only in the context of a specific object with the scope functions.",
        listOf(
            Markup(MarkupType.CODE, 245, 251),
            Markup(MarkupType.CODE, 359, 365),
            Markup(
                MarkupType.LINK,
                4,
                25,
                "https://codelabs.developers.google.com/codelabs/java-to-kotlin/#0",
            ),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Thanks to Walmyr Carvalho and Nelson Glauber for translating the codelab in Brazilian Portuguese!",
        listOf(
            Markup(
                MarkupType.LINK,
                21,
                42,
                "https://codelabs.developers.google.com/codelabs/java-to-kotlin/#0",
            ),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "",
        listOf(
            Markup(
                MarkupType.LINK,
                76,
                96,
                "https://codelabs.developers.google.com/codelabs/java-to-kotlin-pt-br/#0",
            ),
        ),
    ),
)

val paragraphsPost4 = listOf(
    Paragraph(
        ParagraphType.TEXT,
        "TL;DR: Expose resource IDs from ViewModels to avoid showing obsolete data.",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "In a ViewModel, if you’re exposing data coming from resources (strings, drawables, colors…), you have to take into account that ViewModel objects ignore configuration changes such as locale changes. When the user changes their locale, activities are recreated but the ViewModel objects are not.",
        listOf(
            Markup(
                MarkupType.BOLD,
                183,
                197,
            ),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "AndroidViewModel is a subclass of ViewModel that is aware of the Application context. However, having access to a context can be dangerous if you’re not observing or reacting to the lifecycle of that context. The recommended practice is to avoid dealing with objects that have a lifecycle in ViewModels.",
        listOf(
            Markup(MarkupType.CODE, 0, 16),
            Markup(MarkupType.CODE, 34, 43),
            Markup(MarkupType.BOLD, 209, 303),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Let’s look at an example based on this issue in the tracker: Updating ViewModel on system locale change.",
        listOf(
            Markup(
                MarkupType.LINK,
                61,
                103,
                "https://issuetracker.google.com/issues/111961971",
            ),
            Markup(MarkupType.ITALIC, 61, 104),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "The problem is that the string is resolved in the constructor only once. If there’s a locale change, the ViewModel won’t be recreated. This will result in our app showing obsolete data and therefore being only partially localized.",
        listOf(Markup(MarkupType.BOLD, 73, 133)),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "As Sergey points out in the comments to the issue, the recommended approach is to expose the ID of the resource you want to load and do so in the view. As the view (activity, fragment, etc.) is lifecycle-aware it will be recreated after a configuration change so the resource will be reloaded correctly.",
        listOf(
            Markup(
                MarkupType.LINK,
                3,
                9,
                "https://twitter.com/ZelenetS",
            ),
            Markup(
                MarkupType.LINK,
                28,
                36,
                "https://issuetracker.google.com/issues/111961971#comment2",
            ),
            Markup(MarkupType.BOLD, 82, 150),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Even if you don’t plan to localize your app, it makes testing much easier and cleans up your ViewModel objects so there’s no reason not to future-proof.",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "We fixed this issue in the android-architecture repository in the Java and Kotlin branches and we offloaded resource loading to the Data Binding layout.",
        listOf(
            Markup(
                MarkupType.LINK,
                66,
                70,
                "https://github.com/googlesamples/android-architecture/pull/631",
            ),
            Markup(
                MarkupType.LINK,
                75,
                81,
                "https://github.com/googlesamples/android-architecture/pull/635",
            ),
            Markup(
                MarkupType.LINK,
                128,
                151,
                "https://github.com/googlesamples/android-architecture/pull/635/files#diff-7eb5d85ec3ea4e05ecddb7dc8ae20aa1R62",
            ),
        ),
    ),
)

val paragraphsPost5 = listOf(
    Paragraph(
        ParagraphType.TEXT,
        "Working with collections is a common task and the Kotlin Standard Library offers many great utility functions. It also offers two ways of working with collections based on how they’re evaluated: eagerly — with Collections, and lazily — with Sequences. Continue reading to find out what’s the difference between the two, which one you should use and when, and what the performance implications of each are.",
        listOf(
            Markup(MarkupType.CODE, 210, 220),
            Markup(MarkupType.CODE, 241, 249),
            Markup(
                MarkupType.LINK,
                210,
                221,
                "https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/index.html",
            ),
            Markup(
                MarkupType.LINK,
                241,
                250,
                "https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/index.html",
            ),
            Markup(MarkupType.BOLD, 130, 134),
            Markup(MarkupType.BOLD, 195, 202),
            Markup(MarkupType.BOLD, 227, 233),
            Markup(MarkupType.ITALIC, 130, 134),
        ),
    ),
    Paragraph(
        ParagraphType.HEADER,
        "Collections vs sequences",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "The difference between eager and lazy evaluation lies in when each transformation on the collection is performed.",
        listOf(
            Markup(
                MarkupType.ITALIC,
                57,
                61,
            ),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Collections are eagerly evaluated — each operation is performed when it’s called and the result of the operation is stored in a new collection. The transformations on collections are inline functions. For example, looking at how map is implemented, we can see that it’s an inline function, that creates a new ArrayList:",
        listOf(
            Markup(MarkupType.CODE, 229, 232),
            Markup(MarkupType.CODE, 273, 279),
            Markup(MarkupType.CODE, 309, 318),
            Markup(
                MarkupType.LINK,
                183,
                199,
                "https://kotlinlang.org/docs/reference/inline-functions.html",
            ),
            Markup(
                MarkupType.LINK,
                229,
                232,
                "https://github.com/JetBrains/kotlin/blob/master/libraries/stdlib/common/src/generated/_Collections.kt#L1312",
            ),
            Markup(MarkupType.BOLD, 0, 12),
            Markup(MarkupType.ITALIC, 16, 23),
        ),
    ),
    Paragraph(
        ParagraphType.CODE_BLOCK,
        "public inline fun <T, R> Iterable<T>.map(transform: (T) -> R): List<R> {\n" +
                "  return mapTo(ArrayList<R>(collectionSizeOrDefault(10)), transform)\n" +
                "}",
        listOf(
            Markup(MarkupType.BOLD, 7, 13),
            Markup(MarkupType.BOLD, 88, 97),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Sequences are lazily evaluated. They have two types of operations: intermediate and terminal. Intermediate operations are not performed on the spot; they’re just stored. Only when a terminal operation is called, the intermediate operations are triggered on each element in a row and finally, the terminal operation is applied. Intermediate operations (like map, distinct, groupBy etc) return another sequence whereas terminal operations (like first, toList, count etc) don’t.",
        listOf(
            Markup(MarkupType.CODE, 357, 360),
            Markup(MarkupType.CODE, 362, 370),
            Markup(MarkupType.CODE, 372, 379),
            Markup(MarkupType.CODE, 443, 448),
            Markup(MarkupType.CODE, 450, 456),
            Markup(MarkupType.CODE, 458, 463),
            Markup(MarkupType.BOLD, 0, 9),
            Markup(MarkupType.BOLD, 67, 79),
            Markup(MarkupType.BOLD, 84, 92),
            Markup(MarkupType.BOLD, 254, 269),
            Markup(MarkupType.ITALIC, 14, 20),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Sequences don’t hold a reference to the items of the collection. They’re created based on the iterator of the original collection and keep a reference to all the intermediate operations that need to be performed.",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Unlike transformations on collections, intermediate transformations on sequences are not inline functions — inline functions cannot be stored and sequences need to store them. Looking at how an intermediate operation like map is implemented, we can see that the transform function is kept in a new instance of a Sequence:",
        listOf(
            Markup(MarkupType.CODE, 222, 225),
            Markup(MarkupType.CODE, 312, 320),
            Markup(
                MarkupType.LINK,
                222,
                225,
                "https://github.com/JetBrains/kotlin/blob/master/libraries/stdlib/common/src/generated/_Sequences.kt#L860",
            ),
        ),
    ),
    Paragraph(
        ParagraphType.CODE_BLOCK,
        "public fun <T, R> Sequence<T>.map(transform: (T) -> R): Sequence<R>{      \n" +
                "   return TransformingSequence(this, transform)\n" +
                "}",
        listOf(Markup(MarkupType.BOLD, 85, 105)),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "A terminal operation, like first, iterates through the elements of the sequence until the predicate condition is matched.",
        listOf(
            Markup(MarkupType.CODE, 27, 32),
            Markup(
                MarkupType.LINK,
                27,
                32,
                "https://github.com/JetBrains/kotlin/blob/master/libraries/stdlib/common/src/generated/_Sequences.kt#L117",
            ),
        ),
    ),
    Paragraph(
        ParagraphType.CODE_BLOCK,
        "public inline fun <T> Sequence<T>.first(predicate: (T) -> Boolean): T {\n" +
                "   for (element in this) if (predicate(element)) return element\n" +
                "   throw NoSuchElementException(“Sequence contains no element matching the predicate.”)\n" +
                "}",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "If we look at how a sequence like TransformingSequence (used in the map above) is implemented, we’ll see that when next is called on the sequence iterator, the transformation stored is also applied.",
        listOf(
            Markup(MarkupType.CODE, 34, 54),
            Markup(MarkupType.CODE, 68, 71),
        ),
    ),
    Paragraph(
        ParagraphType.CODE_BLOCK,
        "internal class TransformingIndexedSequence<T, R> \n" +
                "constructor(private val sequence: Sequence<T>, private val transformer: (Int, T) -> R) : Sequence<R> {",
        listOf(
            Markup(
                MarkupType.BOLD,
                109,
                120,
            ),
        ),
    ),
    Paragraph(
        ParagraphType.CODE_BLOCK,
        "override fun iterator(): Iterator<R> = object : Iterator<R> {\n" +
                "   …\n" +
                "   override fun next(): R {\n" +
                "     return transformer(checkIndexOverflow(index++), iterator.next())\n" +
                "   }\n" +
                "   …\n" +
                "}",
        listOf(
            Markup(MarkupType.BOLD, 83, 89),
            Markup(MarkupType.BOLD, 107, 118),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Independent on whether you’re using collections or sequences, the Kotlin Standard Library offers quite a wide range of operations for both, like find, filter, groupBy and others. Make sure you check them out, before implementing your own version of these.",
        listOf(
            Markup(MarkupType.CODE, 145, 149),
            Markup(MarkupType.CODE, 151, 157),
            Markup(MarkupType.CODE, 159, 166),
            Markup(
                MarkupType.LINK,
                193,
                207,
                "https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/#functions",
            ),
        ),
    ),
    Paragraph(
        ParagraphType.HEADER,
        "Collections and sequences",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Let’s say that we have a list of objects of different shapes. We want to make the shapes yellow and then take the first square shape.",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Let’s see how and when each operation is applied for collections and when for sequences",
    ),
    Paragraph(
        ParagraphType.SUBHEAD,
        "Collections",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "map is called — a new ArrayList is created. We iterate through all items of the initial collection, transform it by copying the original object and changing the color, then add it to the new list.",
        listOf(Markup(MarkupType.CODE, 0, 3)),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "first is called — we iterate through each item until the first square is found",
        listOf(Markup(MarkupType.CODE, 0, 5)),
    ),
    Paragraph(
        ParagraphType.SUBHEAD,
        "Sequences",
    ),
    Paragraph(
        ParagraphType.BULLET,
        "asSequence — a sequence is created based on the Iterator of the original collection",
        listOf(Markup(MarkupType.CODE, 0, 10)),
    ),
    Paragraph(
        ParagraphType.BULLET,
        "map is called — the transformation is added to the list of operations needed to be performed by the sequence but the operation is NOT performed",
        listOf(
            Markup(MarkupType.CODE, 0, 3),
            Markup(MarkupType.BOLD, 130, 133),
        ),
    ),
    Paragraph(
        ParagraphType.BULLET,
        "first is called — this is a terminal operation, so, all the intermediate operations are triggered, on each element of the collection. We iterate through the initial collection applying map and then first on each of them. Since the condition from first is satisfied by the 2nd element, then we no longer apply the map on the rest of the collection.",
        listOf(Markup(MarkupType.CODE, 0, 5)),
    ),

    Paragraph(
        ParagraphType.TEXT,
        "When working with sequences no intermediate collection is created and since items are evaluated one by one, map is only performed on some of the inputs.",
    ),
    Paragraph(
        ParagraphType.HEADER,
        "Performance",
    ),
    Paragraph(
        ParagraphType.SUBHEAD,
        "Order of transformations",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Independent of whether you’re using collections or sequences, the order of transformations matters. In the example above, first doesn’t need to happen after map since it’s not a consequence of the map transformation. If we reverse the order of our business logic and call first on the collection and then transform the result, then we only create one new object — the yellow square. When using sequences — we avoid creating 2 new objects, when using collections, we avoid creating an entire new list.",
        listOf(
            Markup(MarkupType.CODE, 122, 127),
            Markup(MarkupType.CODE, 157, 160),
            Markup(MarkupType.CODE, 197, 200),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Because terminal operations can finish processing early, and intermediate operations are evaluated lazily, sequences can, in some cases, help you avoid doing unnecessary work compared to collections. Make sure you always check the order of the transformations and the dependencies between them!",
    ),
    Paragraph(
        ParagraphType.SUBHEAD,
        "Inlining and large data sets consequences",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Collection operations use inline functions, so the bytecode of the operation, together with the bytecode of the lambda passed to it will be inlined. Sequences don’t use inline functions, therefore, new Function objects are created for each operation.",
        listOf(
            Markup(
                MarkupType.CODE,
                202,
                210,
            ),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "On the other hand, collections create a new list for every transformation while sequences just keep a reference to the transformation function.",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "When working with small collections, with 1–2 operators, these differences don’t have big implications so working with collections should be ok. But, when working with large lists the intermediate collection creation can become expensive; in such cases, use sequences.",
        listOf(
            Markup(MarkupType.BOLD, 18, 35),
            Markup(MarkupType.BOLD, 119, 130),
            Markup(MarkupType.BOLD, 168, 179),
            Markup(MarkupType.BOLD, 258, 267),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Unfortunately, I’m not aware of any benchmarking study done that would help us get a better understanding on how the performance of collections vs sequences is affected with different sizes of collections or operation chains.",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Collections eagerly evaluate your data while sequences do so lazily. Depending on the size of your data, pick the one that fits best: collections — for small lists or sequences — for larger ones, and pay attention to the order of the transformations.",
    ),
)

val paragraphsPost6 = listOf(
    Paragraph(
        ParagraphType.TEXT,
        "The Android Studio logo redesign caught the attention of the developer community since its sneak peek at the Android Developer Summit. We are thrilled to release the new Android Studio logo with the stable release of Flamingo. Now that the new logo is available to most Android Studio users, we can examine the design changes in greater detail and decode their meaning.",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "This case study offers a comprehensive overview of the design journey, from identifying the initial problem to the final outcome. It explores the critical brand elements that the team needed to consider and the tools used throughout the redesign process. This case study also delves into the various stages of design exploration, highlighting the efforts to create a modern logo while honoring the Android Studio brand's legacy.",
    ),
    Paragraph(
        ParagraphType.HEADER,
        "Identifying the problem",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "You told us the Android Studio logo looked a little weird and complicated. It doesn't shrink down well and it's way too similar to the emulator. We heard you!",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "The Android Studio logo used between 2020 and 2022 was well-suited for print, but it posed challenges when used as an application icon. Its readability suffered when reduced to smaller sizes, and its similarity to the emulator caused confusion.",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Additionally, the use of color alone to differentiate between Canary and Stable versions made it difficult for users with color vision deficiencies.",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "The redesign aimed to resolve these concerns by creating a logo that was easy to read, visually distinctive, and followed the OS guidelines when necessary, ensuring accessibility. The new design also maintained a connection with the Android logo family while honoring its legacy.",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "In this case study, we will delve into the version history and evolution of the Android Studio logo and how it has changed over the years.",
    ),
    Paragraph(
        ParagraphType.HEADER,
        "A brief history of the Android Studio logo",
    ),
    Paragraph(
        ParagraphType.BULLET,
        "2013: The original Android Studio logo was a 3D robot that highlighted the gears and interworking of the bugdroid. At this time, the Android Emulator was the bugdroid.",
        listOf(
            Markup(MarkupType.BOLD, 0, 5),
        ),
    ),
    Paragraph(
        ParagraphType.BULLET,
        "2014: The Android Emulator merged to a flat mark but remained otherwise unchanged.",
        listOf(
            Markup(MarkupType.BOLD, 0, 5),
        ),
    ),
    Paragraph(
        ParagraphType.BULLET,
        "2014-2019: An updated Android Studio logo was introduced featuring an \"A\" compass in front of a green circle.",
        listOf(
            Markup(MarkupType.BOLD, 0, 10),
        ),
    ),
    Paragraph(
        ParagraphType.BULLET,
        "2019: In Canary 3.6, the color palette was updated to match Android 10.",
        listOf(
            Markup(MarkupType.BOLD, 0, 5),
        ),
    ),
    Paragraph(
        ParagraphType.BULLET,
        "2020-2022: With the release of Android Studio 4.1 Canary, the \"A\" compass was reduced to an abstract form placed in front of a blueprint. The Android head was also added, peeking over the top.",
        listOf(
            Markup(MarkupType.BOLD, 0, 10),
        ),
    ),
    Paragraph(
        ParagraphType.HEADER,
        "Understanding the Android brand elements",
    ),
    Paragraph(
        ParagraphType.TEXT,
        "When redesigning a logo, it's important to consider brand elements that unify products within an ecosystem. For the Android Developer ecosystem, the \"robot head\" is a key brand element, alongside the primaryAndroid green color. The secondary colors blue and navy, and tertiary colors like orange, can also be utilized for support.",
    ),
    Paragraph(
        ParagraphType.HEADER,
        "Key objectives",
    ),
    Paragraph(
        ParagraphType.BULLET,
        "Iconography: use recognizable and appropriate symbols, such as compass \"A\" for Android Studio or a device for Android Emulator, to convey the purpose and functionality clearly and quickly.",
        listOf(
            Markup(MarkupType.BOLD, 0, 12),
        ),
    ),
    Paragraph(
        ParagraphType.BULLET,
        "Enhance recognition and scalability: the Android Studio and Android Emulator should prioritize legibility and scalability, ensuring that they can be easily recognized and understood even at smaller sizes.",
        listOf(
            Markup(MarkupType.BOLD, 0, 36),
        ),
    ),
    Paragraph(
        ParagraphType.BULLET,
        "Establish distinction: the Android Studio and Android Emulator need to be easily distinguishable, to avoid confusion.",
        listOf(
            Markup(MarkupType.BOLD, 0, 22),
        ),
    ),
    Paragraph(
        ParagraphType.BULLET,
        "Maintain brand consistency: the Android Studio and Android Emulator designs should be consistent with the overall branding and visual identity of the Android family, while still being distinctive.",
        listOf(
            Markup(MarkupType.BOLD, 0, 27),
        ),
    ),
    Paragraph(
        ParagraphType.BULLET,
        "Ensure accessibility: the logo should be accessible to all users, including those with visual impairments. This means using clear shapes, colors, and contrast.",
        listOf(
            Markup(MarkupType.BOLD, 0, 21),
        ),
    ),
    Paragraph(
        ParagraphType.BULLET,
        "Follow OS guidelines: the updated application icon must align with the Android visual language and conform to the guidelines of macOS, Windows, and Linux operating systems, ensuring consistency and coherence across all platforms.",
        listOf(
            Markup(MarkupType.BOLD, 0, 21),
        ),
    ),
    Paragraph(
        ParagraphType.BULLET,
        "Ensure versatility: the Android Studio logo should be versatile enough to work in a variety of sizes and contexts, such as on different devices and platforms.",
        listOf(
            Markup(MarkupType.BOLD, 0, 20),
        ),
    ),
    Paragraph(
        ParagraphType.TEXT,
        "Read More",
        listOf(
            Markup(
                MarkupType.LINK,
                0,
                9,
                "https://android-developers.googleblog.com/2023/05/redesigning-android-studio-logo.html",
            ),
        ),
    ),
)

val post1 = Post(
    id = "dc523f0ed25c",
    title = "A Little Thing about Android Module Paths",
    subtitle = "How to configure your module paths, instead of using Gradle’s default.",
    url = "https://medium.com/androiddevelopers/gradle-path-configuration-dc523f0ed25c",
    publication = publication,
    metadata = Metadata(
        author = pietro,
        date = "August 02",
        readTimeMinutes = 1,
    ),
    paragraphs = paragraphsPost1,
    imageId = R.drawable.post_1,
    imageThumbId = R.drawable.post_1_thumb,
)

val post2 = Post(
    id = "7446d8dfd7dc",
    title = "Dagger in Kotlin: Gotchas and Optimizations",
    subtitle = "Use Dagger in Kotlin! This article includes best practices to optimize your build time and gotchas you might encounter.",
    url = "https://medium.com/androiddevelopers/dagger-in-kotlin-gotchas-and-optimizations-7446d8dfd7dc",
    publication = publication,
    metadata = Metadata(
        author = manuel,
        date = "July 30",
        readTimeMinutes = 3,
    ),
    paragraphs = paragraphsPost2,
    imageId = R.drawable.post_2,
    imageThumbId = R.drawable.post_2_thumb,
)

val post3 = Post(
    id = "ac552dcc1741",
    title = "From Java Programming Language to Kotlin — the idiomatic way",
    subtitle = "Learn how to get started converting Java Programming Language code to Kotlin, making it more idiomatic and avoid common pitfalls, by…",
    url = "https://medium.com/androiddevelopers/from-java-programming-language-to-kotlin-the-idiomatic-way-ac552dcc1741",
    publication = publication,
    metadata = Metadata(
        author = florina,
        date = "July 09",
        readTimeMinutes = 1,
    ),
    paragraphs = paragraphsPost3,
    imageId = R.drawable.post_3,
    imageThumbId = R.drawable.post_3_thumb,
)

val post4 = Post(
    id = "84eb677660d9",
    title = "Locale changes and the AndroidViewModel antipattern",
    subtitle = "TL;DR: Expose resource IDs from ViewModels to avoid showing obsolete data.",
    url = "https://medium.com/androiddevelopers/locale-changes-and-the-androidviewmodel-antipattern-84eb677660d9",
    publication = publication,
    metadata = Metadata(
        author = jose,
        date = "April 02",
        readTimeMinutes = 1,
    ),
    paragraphs = paragraphsPost4,
    imageId = R.drawable.post_4,
    imageThumbId = R.drawable.post_4_thumb,
)

val post5 = Post(
    id = "55db18283aca",
    title = "Collections and sequences in Kotlin",
    subtitle = "Working with collections is a common task and the Kotlin Standard Library offers many great utility functions. It also offers two ways of…",
    url = "https://medium.com/androiddevelopers/collections-and-sequences-in-kotlin-55db18283aca",
    publication = publication,
    metadata = Metadata(
        author = florina,
        date = "July 24",
        readTimeMinutes = 4,
    ),
    paragraphs = paragraphsPost5,
    imageId = R.drawable.post_5,
    imageThumbId = R.drawable.post_5_thumb,
)

val post6 = Post(
    id = "55db18283ac0",
    title = "Redesigning the Android Studio Logo",
    subtitle = "A case study offering a comprehensive overview of the design journey of the Android Studio product logo.",
    url = "https://android-developers.googleblog.com/2023/05/redesigning-android-studio-logo.html",
    publication = publication,
    metadata = Metadata(
        author = androidStudioTeam,
        date = "May 10",
        readTimeMinutes = 5,
    ),
    paragraphs = paragraphsPost6,
    imageId = R.drawable.post_6,
    imageThumbId = R.drawable.post_6_thumb,
)

val posts: PostFeed =
    PostFeed(
        selectedPost = post6,
        recommendedPost =  listOf(post1, post2, post3),
        popularPosts = listOf(
            post5,
            post1.copy(id = "post6"),
            post2.copy(id = "post7"),
        ),
        recentPosts = listOf(
            post6,
            post3.copy(id = "post8"),
            post4.copy(id = "post9"),
            post5.copy(id = "post10"),
            ),
    )



