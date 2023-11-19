
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Oxygen480-actions-office-chart-pie.svg/128px-Oxygen480-actions-office-chart-pie.svg.png" 
alt="JavaUtil" align="right" style="right:40px; top:18px; width:100px; border:none;" />

<br />

# JavaUtil 

<h3>Overview, core utilities, simple examples</h3>


### :book: &nbsp; Documentation / Examples 

| Package | README | Javadoc top |
|:---|:---|:---|
| :hammer_and_wrench: &nbsp;&nbsp; General util | [org.jutil.util](util/README.md)     | Javadoc |
| :desktop_computer: &nbsp;&nbsp; GUI (Swing)   | [org.jutil.gui](gui/README.md)       | Javadoc |
| :floppy_disk: &nbsp;&nbsp; I/O                | [org.jutil.io](io/README.md)         | Javadoc |
| :gear: &nbsp;&nbsp; System                    | [org.jutil.system](system/README.md) | Javadoc |
| :iphone: &nbsp;&nbsp; Application specific    | [org.jutil.app](app/README.md)       | Javadoc |

<br />

## ⚡️ Quick overview (more examples are in the READMEs of the package)

### Using org.jutil.util.Strings (selected examples)

```Java
import org.jutil.util.*;

	... 
	// create a simple headline (e.g. for logging)
	System.out.println(Strings.repeat(30, "*"));
	System.out.println(Strings.center("***", "headline", "***", 30));
	System.out.println(Strings.repeat(30, "*"));	
	
Output:
******************************
***        headline        ***
******************************

	...
	// create line numbers
	int i = 42;
	System.out.println(
		Strings.fillLeft("" + i + ": ", 7, " ") + "some text");
	i += 1000;
	System.out.println(
		Strings.fillLeft("" + i + ": ", 7, " ") + "some other text");
	
Output:
   42: some text
 1042: some other text
   
	...
	Strings.stripIfEndsWith("myFile.json", ".json");             // returns "myFile"

	...
	Strings.listToString(List.of(1, 2, 3), null, ","", false);   // returns "1,2,3"

	...
	Strings.listToString(List.of(1, 2, 3), "   ", ",\n", false);	
	
Output (indented by "   "):
   1,
   2,
   3

	...
	System.out.println(
		Strings.listToString(List.of("This", "is", "a", "text."), "   <a>, "</a>\n", true)); 

Output:
   <a>This</a>
   <a>is</a>
   <a>a</a>
   <a>text.</a>
   
	...
	indent("  ", 3, "text line");          // returns "      text line" (indented by 6 spaces)
	
More detailed examples can be found in the package README or the Javadoc API.

```

<a href="#top">Back to top</a>

### Using org.jutil.system.CommandExecutor (selected examples)

```Java
import org.jutil.Util;

	... 
	// Linux, Unix, MacOS, others:
	
	CommandExecutor executor = new CommandExecutor("bash", "-c", "ls");
	System.out.println("Exit code: " + executor.getExitCode());
	System.out.println("\n" + executor.getOutput());
	
Output (of the JavaUtil folder):
Exit code: 0

bin
build.xml
CHANGELOG.md
examples
LICENSE
...
	
More detailed examples can be found in the package README or the Javadoc API.

```

<a href="#top">Back to top</a>

### Using org.jutil.Util (selected examples)

```Java
import org.jutil.Util;

	... 
	Util.notImplementedException();		
	// throws a subclass of RuntimeException and text to identify unimplemented
	// code parts 
	
	...
	Util.sleep(100); 	
	// convenience method: sleeps 100ms or until interruption, see 
	// implementation or Javadoc for details
	
	...
	String prompt = Util.prompt("go further: ");		// console IO
	System.out.println("Prompted input: '" + prompt + "'");
	
More detailed examples can be found in the package README or the Javadoc API.

```

[Overview][examples_top_url] &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href="#top">Back to top</a>

<!-- Repository -->

[repo_url]: https://github.com/openworld42/JavaUtil
[examples_top_url]: https://github.com/openworld42/JavaUtil/tree/master/examples/README.md
[javadoc_url]: https://htmlpreview.github.io/?https://raw.githubusercontent.com/openworld42/JavaUtil/master/javadoc/index.html

