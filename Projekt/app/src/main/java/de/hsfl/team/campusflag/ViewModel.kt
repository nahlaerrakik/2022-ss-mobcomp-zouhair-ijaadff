package de.hsfl.team.campusflag

import android.app.Application
import android.text.Editable
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class ViewModel (application: Application) : AndroidViewModel(application) {

    private val apiRepository = ApiRepository.getInstance(getApplication())

    private val gameId: MutableLiveData<Int> = MutableLiveData()
    private var host: MutableLiveData<Player> = MutableLiveData()
    private var player: MutableLiveData<Player> = MutableLiveData()

    fun getGameId(): MutableLiveData<Int> = gameId
    fun getHost(): MutableLiveData<Player> = host
    fun getPlayer(): MutableLiveData<Player> = player

    fun setHost(s: Editable) {
        host.value = Player(null, s.toString(), null, null, null)
    }

    fun setPlayer(s: Editable) {
        player.value = Player(null, s.toString(), null, null, null)
    }

    fun setGameId(s: Editable) {
        if (s.toString().isNotEmpty()) {
            gameId.value = s.toString().toInt()
        }
    }

    fun createGame() {
        val game = host.value?.let {
            Game(
                gameId.value,
                it,
                null,
                null,
            )
        }

        if (game != null) {
            host.value?.let {
                apiRepository.postGame(it) {
                    gameId.value = it.gameId
                    host.value = it.host
                }
            }
        }
    }

    fun joinGame(callback: (Boolean) -> (Unit)) {
        val playerPost = Player(
            gameId.value,
            player.value?.name,
            null,
            null,
            null
        )

        apiRepository.joinGame(playerPost){
            if(it.token == null){
                Toast.makeText(getApplication(), "Name already exists",
                    Toast.LENGTH_LONG).show()
                callback(true)
            }
            else{
                callback(false)
            }
        }
    }

    fun fetchPlayers() {
        val game = host.value?.let {
            Game(
                gameId.value,
                host.value!!,
                null,
                null,
            )
        }

        host.value?.let {
            game?.let { it1 ->
                apiRepository.getPlayers(it1) {
                    Log.d("fetchPlayers", it.toString())
                }
            }
        }
    }
}