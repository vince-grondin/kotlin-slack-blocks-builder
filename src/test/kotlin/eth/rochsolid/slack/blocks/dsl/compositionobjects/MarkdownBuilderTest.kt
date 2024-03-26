package eth.rochsolid.slack.blocks.dsl.compositionobjects

import assertk.assertThat
import assertk.assertions.isEqualTo
import eth.rochsolid.slack.blocks.models.compositionobjects.Text
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class MarkdownBuilderTest {
    @ParameterizedTest
    @DisplayName(
        "Given all fields are specified " +
                "When building " +
                "Then an instance of the markdown composition object is returned with all the fields populated"
    )
    @ValueSource(booleans = [true, false])
    fun t1(verbatim: Boolean) {
        val result = MarkdownBuilder("A message *with some bold text* and _some italicized text_.").apply {
            this.verbatim = verbatim
        }.build()

        assertThat(result).isEqualTo(
            Text.Markdown(
                text = "A message *with some bold text* and _some italicized text_.",
                verbatim = verbatim
            )
        )
    }

    @Test
    @DisplayName(
        "Given only required fields are specified " +
                "When building " +
                "Then an instance of the markdown composition object is returned with only the required fields populated"
    )
    fun t2() {
        val result = MarkdownBuilder("A message *with some bold text* and _some italicized text_.").build()

        assertThat(result).isEqualTo(
            Text.Markdown(
                text = "A message *with some bold text* and _some italicized text_.",
                verbatim = null
            )
        )
    }
}
