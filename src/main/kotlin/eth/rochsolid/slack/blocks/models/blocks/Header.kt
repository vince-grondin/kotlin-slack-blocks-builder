package eth.rochsolid.slack.blocks.models.blocks

import kotlinx.serialization.SerialName


/**
 * Displays a larger-sized text block.
 * A header is a plain-text block that displays in a larger, bold font.
 * Use it to delineate between different groups of content in your app's surfaces.
 *
 * Example ([view this in Block Kit Builder](https://app.slack.com/block-kit-builder/?_gl=1*yspqej*_gcl_au*MTI4ODM0OTk1NS4xNzExMTc3MTY0#%7B%22type%22:%22home%22,%22blocks%22:%5B%7B%22type%22:%22header%22,%22text%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Budget%20Performance%22%7D%7D,%7B%22type%22:%22divider%22%7D,%7B%22type%22:%22section%22,%22fields%22:%5B%7B%22type%22:%22mrkdwn%22,%22text%22:%22*Current%20Quarter*%5CnBudget:%20$18,000%20(ends%20in%2053%20days)%5CnSpend:%20$4,289.70%5CnRemain:%20$13,710.30%22%7D,%7B%22type%22:%22mrkdwn%22,%22text%22:%22*Top%20Expense%20Categories*%5Cn:airplane:%20Flights%20%C2%B7%2030%25%5Cn:taxi:%20Taxi%20/%20Uber%20/%20Lyft%20%C2%B7%2024%25%20%5Cn:knife_fork_plate:%20Client%20lunch%20/%20meetings%20%C2%B7%2018%25%22%7D%5D%7D,%7B%22type%22:%22context%22,%22elements%22:%5B%7B%22type%22:%22image%22,%22image_url%22:%22https://api.slack.com/img/blocks/bkb_template_images/placeholder.png%22,%22alt_text%22:%22placeholder%22%7D%5D%7D,%7B%22type%22:%22header%22,%22text%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Expenses%20Awaiting%20Your%20Approval%22%7D%7D,%7B%22type%22:%22divider%22%7D,%7B%22type%22:%22context%22,%22elements%22:%5B%7B%22type%22:%22mrkdwn%22,%22text%22:%22Submitted%20by%22%7D,%7B%22type%22:%22image%22,%22image_url%22:%22https://api.slack.com/img/blocks/bkb_template_images/profile_3.png%22,%22alt_text%22:%22Dwight%20Schrute%22%7D,%7B%22type%22:%22mrkdwn%22,%22text%22:%22*Dwight%20Schrute*%22%7D%5D%7D,%7B%22type%22:%22section%22,%22text%22:%7B%22type%22:%22mrkdwn%22,%22text%22:%22*Team%20Lunch%20(Internal)*%5CnCost:%20*$85.50USD*%5CnDate:%20*10/16/2019*%5CnService%20Provider:%20*Honest%20Sandwiches*%20%20%5CnExpense%20no.%20*%3Cfakelink.toUrl.com%7C#1797PD%3E*%22%7D,%22accessory%22:%7B%22type%22:%22image%22,%22image_url%22:%22https://api.slack.com/img/blocks/bkb_template_images/creditcard.png%22,%22alt_text%22:%22credit%20card%22%7D%7D,%7B%22type%22:%22actions%22,%22elements%22:%5B%7B%22type%22:%22button%22,%22text%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Approve%22,%22emoji%22:true%7D,%22style%22:%22primary%22,%22value%22:%22approve%22%7D,%7B%22type%22:%22button%22,%22text%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Decline%22,%22emoji%22:true%7D,%22style%22:%22danger%22,%22value%22:%22decline%22%7D,%7B%22type%22:%22button%22,%22text%22:%7B%22type%22:%22plain_text%22,%22text%22:%22View%20Details%22,%22emoji%22:true%7D,%22value%22:%22details%22%7D%5D%7D,%7B%22type%22:%22divider%22%7D,%7B%22type%22:%22context%22,%22elements%22:%5B%7B%22type%22:%22mrkdwn%22,%22text%22:%22Submitted%20by%22%7D,%7B%22type%22:%22image%22,%22image_url%22:%22https://api.slack.com/img/blocks/bkb_template_images/profile_2.png%22,%22alt_text%22:%22Pam%20Beasely%22%7D,%7B%22type%22:%22mrkdwn%22,%22text%22:%22*Pam%20Beasely*%22%7D%5D%7D,%7B%22type%22:%22section%22,%22text%22:%7B%22type%22:%22mrkdwn%22,%22text%22:%22*Flights%20to%20New%20York*%5CnCost:%20*$520.78USD*%5CnDate:%20*10/18/2019*%5CnService%20Provider:%20*Delta%20Airways*%5CnExpense%20no.%20*%3Cfakelink.toUrl.com%7C#1803PD%3E*%22%7D,%22accessory%22:%7B%22type%22:%22image%22,%22image_url%22:%22https://api.slack.com/img/blocks/bkb_template_images/plane.png%22,%22alt_text%22:%22plane%22%7D%7D,%7B%22type%22:%22actions%22,%22elements%22:%5B%7B%22type%22:%22button%22,%22text%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Approve%22,%22emoji%22:true%7D,%22style%22:%22primary%22,%22value%22:%22approve%22%7D,%7B%22type%22:%22button%22,%22text%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Decline%22,%22emoji%22:true%7D,%22style%22:%22danger%22,%22value%22:%22decline%22%7D,%7B%22type%22:%22button%22,%22text%22:%7B%22type%22:%22plain_text%22,%22text%22:%22View%20Details%22,%22emoji%22:true%7D,%22value%22:%22details%22%7D%5D%7D%5D%7D)):
 * ```json
 * {
 *   "type": "header",
 *   "text": {
 *     "type": "plain_text",
 *     "text": "Budget Performance"
 *   }
 * }
 * ```
 */
data class Header(
    /**
     * A unique identifier for a block. If not specified, a block_id will be generated by the Slack API.
     * You can use this [blockID] when you receive an interaction payload to identify the source of the action.
     * Maximum length for this field is 255 characters. [blockID] should be unique for each message and each iteration
     * of a message. If a message is updated, use a new [blockID].
     */
    @SerialName("block_id")
    override val blockID: BlockID?,
    /**
     * The text for the block, in the form of a [CompositionObject.Text.PlainText] text object.
     * Maximum length for the text in this field is 150 characters.
     */
    val text: CompositionObject.Text.PlainText
) : Block(type = Type.HEADER)
