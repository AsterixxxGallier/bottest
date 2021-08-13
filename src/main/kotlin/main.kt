import com.gitlab.kordlib.core.Kord
import com.gitlab.kordlib.core.entity.ReactionEmoji
import com.gitlab.kordlib.core.event.message.MessageCreateEvent
import com.gitlab.kordlib.core.on
import kotlinx.coroutines.delay

suspend fun main() {
	val client = Kord(System.getenv("BOT_TOKEN"))
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