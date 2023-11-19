
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Oxygen480-actions-office-chart-pie.svg/128px-Oxygen480-actions-office-chart-pie.svg.png" 
alt="JavaUtil" align="right" style="right:40px; top:18px; width:100px; border:none;" />

<br />

# JavaUtil 

<h3>System relevant classes:  &nbsp; org.jutil.system.*</h3>


### :book: &nbsp; Documentation / Examples  &nbsp; &nbsp; &nbsp; &nbsp; [Javadoc Overview][javadoc_url]

| Class | README |
|:---|:---|
| [org.jutil.system.CommandExecutor](#using-orgjutilsystemcommandexecutor-selected-examples)     | [Javadoc][javadoc_commandexecutor] |

<br />

<br />

**JavaUtil is still in a formation process - but you can watch things grow.**

<br />



## ⚡️ Quick overview

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
	
	// MS-Windows:
	
	CommandExecutor executor = new CommandExecutor("cmd.exe", "/c", "ping -n 3 localhost");
	
More detailed examples can be found in the package README or the Javadoc API.

```

<a href="#top">Back to top</a>


[Overview][examples_top_url] &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href="#top">Back to top</a>

<!-- Repository -->

[repo_url]: https://github.com/openworld42/JavaUtil
[examples_top_url]: https://github.com/openworld42/JavaUtil/tree/master/examples/README.md

[javadoc_url]: https://htmlpreview.github.io/?https://raw.githubusercontent.com/openworld42/JavaUtil/master/javadoc/index.html
[javadoc_commandexecutor]: https://htmlpreview.github.io/?https://raw.githubusercontent.com/openworld42/JavaUtil/master/javadoc/org/system/CommandExecutor.html

