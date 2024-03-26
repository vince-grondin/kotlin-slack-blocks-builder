package eth.rochsolid.slack.blocks.dsl.compositionobjects

import eth.rochsolid.slack.blocks.models.compositionobjects.Text

sealed class TextBuilder<T : Text>(protected val text: String) {
    abstract fun build(): T
}

class MarkdownBuilder(text: String) : TextBuilder<Text.Markdown>(text) {
    var verbatim: Boolean? = null

    override fun build(): Text.Markdown = Text.Markdown(text = text, verbatim = verbatim)
}

class PlainTextBuilder(text: String) : TextBuilder<Text.PlainText>(text) {
    var emoji: Boolean? = null

    override fun build(): Text.PlainText = Text.PlainText(text = text, emoji = emoji)
}
