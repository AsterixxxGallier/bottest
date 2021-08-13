import com.gitlab.kordlib.core.Kord
import com.gitlab.kordlib.core.entity.ReactionEmoji
import com.gitlab.kordlib.core.event.message.MessageCreateEvent
import com.gitlab.kordlib.core.on
import kotlinx.coroutines.delay

suspend fun main() {
	//TODO secure the token!!!
	val client = Kord("ODc1NzQ1Mjg4MDU1MjkxOTM0.YRZ_Ww.a8Yn2igNVW_AXkrTiZ8h7_fISxM")
	val pingPong = ReactionEmoji.Unicode("\uD83C\uDFD3")

	client.on<MessageCreateEvent> {
		if(message.content != "!ping") return@on

		val response = message.channel.createMessage("Pong!")
		response.addReaction(pingPong)

		delay(5000)
		message.delete()
		response.delete()
	}

	client.login()

}