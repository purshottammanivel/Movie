package com.purshottam.store.movie.data.model

import com.purshottam.store.movie.domain.model.Movie

data class Result(
    val adult               : Boolean,
    val backdrop_path       : String?,
    val genre_ids           : List<Int>?,
    val id                  : Int?,
    val original_language   : String?,
    val original_title      : String?,
    val overview            : String?,
    val popularity          : Double?,
    val poster_path         : String?,
    val release_date        : String?,
    val title               : String?,
    val video               : Boolean,
    val vote_average        : Double?,
    val vote_count          : Int?
)

fun Result.toDomainMovie(): Movie {
    return Movie(
        adult = this.adult                          ?:  false,
        backdropPath = this.backdrop_path           ?:  "",
        genreIds = genre_ids                        ?:  null,
        id = this.id                                ?:  0,
        originalLanguage = this.original_language   ?:  "",
        originalTitle = this.original_title         ?:  "",
        overview = this.overview                    ?:  "",
        popularity = this.popularity                ?:  0.0,
        posterPath = this.poster_path               ?:  "",
        releaseDate = this.release_date             ?:  "",
        title = this.title                          ?:  "",
        video = this.video                          ?:  false,
        voteAverage = this.vote_average             ?:  0.0,
        voteCount = this.vote_count                 ?:  0
    )
}