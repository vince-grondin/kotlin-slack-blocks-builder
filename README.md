##  Slack Block Kotlin DSL for Effortless Block Building

This library provides a user-friendly Kotlin DSL for building
[Slack Blocks](https://api.slack.com/reference/block-kit#blocks), simplifying the process of creating interactive and 
visually appealing messages within your Slack applications.

**Benefits:**

* **Intuitive DSL:** Build Slack Blocks with a clear and concise syntax, focusing on the content rather than complex JSON structures.
* **Improved Readability:** Maintain cleaner and more readable code compared to raw JSON.
* **Reduced Errors:**  Catch potential errors during compilation instead of runtime surprises with JSON.

**Getting Started:**

1. **Add the dependency (not published yet):**

   ```
   implementation("eth.rochsolid.kotlin-slack-blocks-builder:1.0.0")
   ```

2. **Start Building Blocks:**

   ```kotlin
   val block = actions {
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
   ```

### Available Block Types (more to be added soon!)

- `actions`: Create interactive blocks containing buttons and other elements.

### Element Configuration Options (more to be added soon!)

- `button`: Configure button text, action ID, value, and styles.
- `confirm`: Define confirmation dialog with title, text, confirm/deny options, and style.

**Contributing**

Contributions are closed at this time as this project is in its inphancy.
We will soon welcome contributions to this project! At which point, feel free to submit pull requests for bug fixes
new features, or improved documentation.

**License**

This library is licensed under the MIT License. See the LICENSE file for details.

**Stay Updated**

Keep an eye on this README for updates on supported block types, element options, and future improvements! 
