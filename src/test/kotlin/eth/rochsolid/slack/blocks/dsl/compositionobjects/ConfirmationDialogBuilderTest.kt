package eth.rochsolid.slack.blocks.dsl.compositionobjects

import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isInstanceOf
import eth.rochsolid.slack.blocks.models.compositionobjects.ConfirmationDialog
import eth.rochsolid.slack.blocks.models.compositionobjects.Text
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ConfirmationDialogBuilderTest {
    @Test
    @DisplayName(
        "Given all fields are specified " +
                "And the button uses the primary style " +
                "When building " +
                "Then an instance of the confirmation dialog is returned with all the fields populated " +
                "And the primary style"
    )
    fun t1() {
        val result = ConfirmationDialogBuilder().apply {
            title("Are you sure?")
            text("Wouldn't you prefer a good game of chess?")
            confirm("Do it :grinning:") {
                emoji = true
            }
            deny("Stop, I've changed my mind!")
            primaryStyle()
        }.build()

        assertThat(result).isEqualTo(
            ConfirmationDialog(
                title = Text.PlainText(
                    emoji = null,
                    text = "Are you sure?"
                ),
                text = Text.PlainText(
                    emoji = null,
                    text = "Wouldn't you prefer a good game of chess?"
                ),
                confirm = Text.PlainText(
                    emoji = true,
                    text = "Do it :grinning:"
                ),
                deny = Text.PlainText(
                    emoji = null,
                    text = "Stop, I've changed my mind!"
                ),
                style = ConfirmationDialog.Style.PRIMARY
            )
        )
    }

    @Test
    @DisplayName(
        "Given all fields are specified " +
                "And the button uses the danger style " +
                "When building " +
                "Then an instance of the confirmation dialog is returned with all the fields populated " +
                "And the danger style"
    )
    fun t2() {
        val result = ConfirmationDialogBuilder().apply {
            title("Are you sure?")
            text("Wouldn't you prefer a good game of chess?")
            confirm("Do it")
            deny("Stop, I've changed my mind! :grinning:") {
                emoji = true
            }
            dangerStyle()
        }.build()

        assertThat(result).isEqualTo(
            ConfirmationDialog(
                title = Text.PlainText(
                    emoji = null,
                    text = "Are you sure?"
                ),
                text = Text.PlainText(
                    emoji = null,
                    text = "Wouldn't you prefer a good game of chess?"
                ),
                confirm = Text.PlainText(
                    emoji = null,
                    text = "Do it"
                ),
                deny = Text.PlainText(
                    emoji = true,
                    text = "Stop, I've changed my mind! :grinning:"
                ),
                style = ConfirmationDialog.Style.DANGER
            )
        )
    }

    @Test
    @DisplayName(
        "Given some required fields are not specified " +
                "When building " +
                "Then a UninitializedPropertyAccessException exception is thrown"
    )
    fun t3() {
        assertFailure {
            ConfirmationDialogBuilder().apply {
                title("Are you sure?")
                dangerStyle()
            }.build()
        }.isInstanceOf(UninitializedPropertyAccessException::class)
    }
}
