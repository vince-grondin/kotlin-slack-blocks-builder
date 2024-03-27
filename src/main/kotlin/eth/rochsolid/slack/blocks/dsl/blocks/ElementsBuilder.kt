package eth.rochsolid.slack.blocks.dsl.blocks

import eth.rochsolid.slack.blocks.dsl.BlockDslMarker
import eth.rochsolid.slack.blocks.dsl.elements.ButtonBuilder
import eth.rochsolid.slack.blocks.dsl.elements.ElementBuilder
import eth.rochsolid.slack.blocks.models.elements.Element

/**
 * Builder for building a list of [Element]s.
 */
@BlockDslMarker
class ElementsBuilder {
    private val elements: MutableList<ElementBuilder<*>> = mutableListOf()

    fun build(): List<Element> = elements.map(ElementBuilder<*>::build)

    fun button(text: String, fn: ButtonBuilder.() -> Unit) {
        elements.add(ButtonBuilder(text).apply(fn))
    }
}
