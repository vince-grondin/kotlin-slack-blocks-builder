package eth.rochsolid.slack.blocks.dsl.blocks

import assertk.assertThat
import assertk.assertions.isEqualTo
import eth.rochsolid.slack.blocks.models.blocks.Actions
import eth.rochsolid.slack.blocks.models.blocks.Block
import eth.rochsolid.slack.blocks.models.compositionobjects.ConfirmationDialog
import eth.rochsolid.slack.blocks.models.compositionobjects.Text
import eth.rochsolid.slack.blocks.models.elements.ActionableElement
import eth.rochsolid.slack.blocks.models.elements.Button
import eth.rochsolid.slack.blocks.models.elements.Element
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.net.URL
import java.util.stream.Stream

internal class ActionsBuilderTest {
    private fun scenarios(): Stream<Arguments> = Stream.of(
        // An actions block with a button
        Arguments.of(
            ActionsBuilder().apply {
                blockID = "actions1"

                elements {
                    button("Click Me") {
                        accessibilityLabel = "button"
                        actionID = "button"
                        value = "click_me_123"

                        confirm {
                            title("Are you sure?")
                            text("Wouldn't you prefer a good game of chess?")
                            confirm("Do it")
                            deny("Stop, I've changed my mind! :grinning:") {
                                emoji = true
                            }
                            dangerStyle()
                        }

                        focusOnLoad()

                        primaryStyle()

                        url = "https://slack.com"
                    }
                }
            },
            Actions(
                blockID = Block.BlockID("actions1"),
                elements = listOf(
                    Button(
                        actionID = ActionableElement.ActionID("button"),
                        text = Text.PlainText(
                            emoji = null,
                            text = "Click Me"
                        ),
                        url = URL("https://slack.com"),
                        value = "click_me_123",
                        style = Button.Style.PRIMARY,
                        confirm = ConfirmationDialog(
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
                        ),
                        focusOnLoad = true,
                        accessibilityLabel = "button"
                    )
                )
            )
        )
    )

    @ParameterizedTest
    @MethodSource("scenarios")
    @DisplayName(
        "Given a builder instance created via the DSL " +
                "When building " +
                "Then an instance of the type is created as expected"
    )
    fun t1(builder: ActionsBuilder, expected: Actions) {
        val result = builder.build()

        assertThat(result).isEqualTo(expected)
    }
}
