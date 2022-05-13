package de.hsfl.team.campusflag

import org.json.JSONArray


data class Game(
    val gameId: Int?,
    val host: Player,
    val state: Int?,
    val players: JSONArray?
)

data class Player(
    val gameId: Int?
    , val name: String?
    , val team: Int?
    , val token: String?
    , val addr: String?
)
