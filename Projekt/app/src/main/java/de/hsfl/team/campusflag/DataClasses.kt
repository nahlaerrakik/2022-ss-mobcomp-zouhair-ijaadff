package de.hsfl.team.campusflag

import org.json.JSONArray


data class Game(
    val game: Int?,
    val token: String?,
    val teamOne: Team?,
    val teamTwo: Team?,
    val host: Player,
    val state: Int?,
    val players: JSONArray?
)

data class Team(
    val players: MutableList<Player>
    , val id: Int
    , val color: String
)

data class Player(
    val game: Int?
    , val name: String?
    , val team: Int?
    , val token: String?
    , val addr: String?
)
