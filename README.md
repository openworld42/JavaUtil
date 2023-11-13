# JavaTemplate

Provides Java(TM) template files as an aid to start a new project. If you like it (better: if it helped you) please give a star - to motivate me. 

To use it, simply copy over the files you want to use and delete the parts or files you don't need.
Take less files from the [stable 1.0.x branch](https://github.com/openworld42/JavaTemplate/tree/stable-1.0) if you dont 
need the full **JavaTemplate**.

Since it is a template for repeated needs during project setup, it does almost 
nothing by itself, but runs a simple GUI (Graphical User Interface) to demonstrate its use.

To run it: download the **templateVxxx.jar** file and call it from the command line using

**java -jar templateVxxx.jar**

where **xxx** is the current version. You need a Java runtime/JDK installed (at least version 17 - check on command line using **java -version**).<br/>
To get it: **Linux**: simply use your package manager, **Windows/macOS/others**: download and install JDK from [here](https://openjdk.java.net/).<br/> 

I have been using/growing this for fast setups of my own projects over years, starting with 
500-1000 (or even 2500) lines of code from the beginning, concentrating on the project needs - and not 
repeat the somewhat boring tasks. I tried to keep it simple but functional, 
thus reducing unnecessary complexity.

And yes, it's all source under your hood/needs, not a framework to live with, and no dependencies. 
It's a template, you modify it, delete the unnecessary parts, and start with some infrastructure from the very beginning. Use the saved time for other things you like.

### Javadocs / API
Download (or clone) the JavaTemplate project, if downloaded as a zip file extract it. Open the API with your browser:

**Classes**: docs/allclasses-index.html

**Packages**: docs/allpackages-index.html

**Overview**: docs/index.html

The **API** contains:

<ul>
	<li><b>Main</b>: an application entry class catching all unexpected Exceptions, starting a GUI (can be deleted), with logging and 
		command line option parsing. Properties (like last window positions) are included.</li>
	<li><b>AppProperties</b>: application specific property object (e.g. for window sizes and small items to persist).
		Default properties are automatically stored as XML or key/value files and can be read back easily at the next application start.</li>
	<li><b>CommandLineArgs</b>: a specimen for command line options and the parsing.</li>
	<li><b>Usage</b>: the usual -h --help output and other options specimen (documentation is very often underestimated ;-).</li>
	<li><b>Logger</b>: a simple logging class (yes, I know Log4J, of course), but I like simple things under my hood. 
		One needs rarely the full complexity (if so, it is easy to start with Logger and use it as a wrapper when something is going to get big).</li>
	<li><b>Version</b>: a simple version (release) class for version management.</li>
	<li><b>Msg</b> and <b>Message</b>: a good start for a possible distribution of other languages/labels/tags, with fair cost at 
		the beginning of a new project. Add files for other languages later - with almost no changes to the code.</li>
	<li><b>Util</b>: an utility class with several static methods, needed in most projects (e.g. wanted to 
		write something (array, list) to the output, but break the lines if too long? 
		Always searching the javadocs for date or decimal formats?
		Find files in a directory with a prefix (log rotation, versioning, etc.)?
		Rename backup files to save the history?
		Prompt and read on stdin for debugging reasons?
		Convert a stacktrace into a String?
		Read/write a full content string to/from a file/URL?
		Various string manipulations, easy sleeping, and more).
		If you want to contribute your 2 cents (and use the code style of the project) or 
		if you have any suggestions on often needed items: provide useful methods/ideas - welcome on board (Apache license!).</li>
	<li><b>Parser</b>: a text file parser specimen with line numbers (helps debugging a lot), tokenize items to lists, and more.</li>
	<li>your 2 cents may go here: ...</li>
</ul>

<b>XML</b> of course, nowadays:
<ul>
	<li><b>XmlWriter</b>: a simple way to serialize things/objects to a XML file (quick method).</li>
	<li><b>XmlWritable</b>: an interface an object may implement to make it writable to XML using XmlWriter.</li>
	<li><b>XML parser</b>: a specimen</li>
	<li><b>XmlExample</b>: a specimen for a XML turnaround, writing out some objects and reading them back.</li>
</ul>`
Last, but not least, don't forget the <b>GUI (Graphical User Interface)</b>:
<ul>
	<li><b>Look&Feel</b>: is configurable, or can be set to a fixed one</li>
	<li><b>MainView</b> (swing based): a main window specimen with almost everything to delete out if not needed. 
		Contains code snippets for ToolBar, Menu, status line, some widgets, listeners, action handling/dispatching, focus, window closing actions,
		simple dialog examples (file chooser, question input, etc.), and yes, layout (e.g. an easy way to use GrindBagLayout!).</li>
	<li><b>Gbc</b>: ride the GridBagConstraints horse for GrindBagLayout in a kingsman way - short/fast learning curve, 
		index placed (grid x/y placement), automated insets for a good look/feel of the widgets, anchoring (e.g. "NW t" for 
		north-west anchor with automated (wider) inset at the top), 
		filler() to drag/push widgets and more: take a look for its use in MainView. No drawing tools needed anymore.</li>
	<li><b>Gui</b>: the utility class for the graphical user interface (always wanted to center the main window at startup?
		Error/Warning/Info dialog not braking down to 3 lines of code? Use Gui)</li>
	<li><b>Dialog</b>: a specimen for a JDialog to start with, if needed in your application.</li>
</ul>

Note: all files are **Apache 2.0 licensed**, therefore could be used as a starter for any other GPL/Apache/FOSS project, as well as the use of individual classes.<br/>

(If you need just the source for a project setup, there is no need to refer to me as an author, but it would be a handsome gesture. 
I will NOT use my right of legal action for that, it's just my 2 cents for the mankind)</p>

Author: Heinz Silberbauer  (You like it? Spend a Github Star to motivate me :whale:)




