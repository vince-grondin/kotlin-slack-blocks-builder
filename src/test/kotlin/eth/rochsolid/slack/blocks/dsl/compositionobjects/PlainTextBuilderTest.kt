package eth.rochsolid.slack.blocks.dsl.compositionobjects

import assertk.assertThat
import assertk.assertions.isEqualTo
import eth.rochsolid.slack.blocks.models.compositionobjects.Text
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class PlainTextBuilderTest {
    @ParameterizedTest
    @DisplayName(
        "Given all fields are specified " +
                "When building " +
                "Then an instance of the plain text composition object is returned " +
                "And all the fields are populated"
    )
    @ValueSource(booleans = [true, false])
    fun t1(emoji: Boolean) {
        val result = PlainTextBuilder("A message with plain text.").apply {
            this.emoji = emoji
        }.build()

        assertThat(result).isEqualTo(
            Text.PlainText(
                text = "A message with plain text.",
                emoji = emoji
            )
        )
    }

    @Test
    @DisplayName(
        "Given only required fields are specified " +
                "When building " +
                "Then an instance of the plain text composition object is returned " +
                "And only the required fields are populated"
    )
    fun t2() {
        val result = PlainTextBuilder("A message with plain text.").build()

        assertThat(result).isEqualTo(
            Text.PlainText(
                text = "A message with plain text.",
                emoji = null
            )
        )
    }
}
