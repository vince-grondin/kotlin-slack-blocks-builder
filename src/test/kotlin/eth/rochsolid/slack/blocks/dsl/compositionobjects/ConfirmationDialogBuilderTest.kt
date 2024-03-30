package eth.rochsolid.slack.blocks.dsl.compositionobjects

import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isInstanceOf
import eth.rochsolid.slack.blocks.models.compositionobjects.ConfirmationDialog
import eth.rochsolid.slack.blocks.models.compositionobjects.Text
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class ConfirmationDialogBuilderTest {
    private fun successScenarios(): Stream<Arguments> = Stream.of(
        Arguments.of(
            ConfirmationDialogBuilder().apply {
                title("Are you sure?")
                text("Wouldn't you prefer a good game of chess?")
                confirm("Do it :grinning:") {
                    emoji = true
                }
                deny("Stop, I've changed my mind!")
                primaryStyle()
            },
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
        ),
        Arguments.of(
            ConfirmationDialogBuilder().apply {
                title("Are you sure?")
                text("Wouldn't you prefer a good game of chess?")
                confirm("Do it")
                deny("Stop, I've changed my mind! :grinning:") {
                    emoji = true
                }
                dangerStyle()
            },
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
    )

    @ParameterizedTest
    @MethodSource("successScenarios")
    @DisplayName(
        "Given a builder instance created via the DSL " +
                "When building " +
                "Then an instance of the type is created as expected"
    )
    fun t1(builder: ConfirmationDialogBuilder, expected: ConfirmationDialog) {
        val result = builder.build()

        assertThat(result).isEqualTo(expected)
    }

    @Test
    @DisplayName(
        "Given some required fields are not specified " +
                "When building " +
                "Then a UninitializedPropertyAccessException exception is thrown"
    )
    fun t2() {
        assertFailure {
            ConfirmationDialogBuilder().apply {
                title("Are you sure?")
                dangerStyle()
            }.build()
        }.isInstanceOf(UninitializedPropertyAccessException::class)
    }
}
