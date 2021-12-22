# The News API REST Project

The Backend Api Application of The News project.

## Class Model
` ` `puml
@startuml
package externals^ #ffcccc{
package org.threeten.bp {
class ZonedDateTime {
...
}
class ZoneId {
...
}
}

    package net.openhft.hashing {
        class LongHashFunction {
        ...
        }
    }
    
    package com.github.javafaker {
        class Faker {
            ...
        }
    }
    
    package org.springframework.data.jpa.repository.JpaRepository {
        Class JpaRepository {
            ...
        }
    }
}


package cl.ucn.disc.dsm.fsanchez.newsapi {

    package model #ccffcc {
        
        class News <<entity>> {
            -id: Long
            -title: String
            -source: String
            -author: String
            -url: String
            -urlImage: String
            -description: String
            -content: String
            +News(...)
            +getId(): Long
            +getTilte(): String
            +getSource(): String
            +getAuthor(): String
            +getUrl(): String
            +getUrlImage(): String
            +getDescription(): String
            +getContent(): String
            +getPublishedAt(): ZonedDateTime
        }
        News *--> "1" ZonedDateTime : -publishedAt
        News ..> LongHashFunction : <<use>>
    }

    package services #ccccff {

        interface NewsRepository <<interface>> {
        }
        NewsRepository ..> News : <<use>>
        NewsRepository *--> "1" JpaRepository : <<extends>>
        
        class NewsController {
            -newsRepository: NewsRepository
            +NewsController(...)
            +all(): List<News>
            +reloadNewsFromNewsApi(): void
            -toNews(): News
            +one(): News
        }
        NewsController ..> News : <<use>>

        class TheNewsApiApplication {
            -newsRepository: NewsRepository
            +main(): void
            #initializingDatabase(): InitializingBean
        }
        TheNewsApiApplication ..|> NewsRepository
        

    }

}
@enduml
` ` `
## License
[MIT](https://choosealicense.com/licenses/mit/)