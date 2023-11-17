
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Oxygen480-actions-office-chart-pie.svg/128px-Oxygen480-actions-office-chart-pie.svg.png" 
alt="JavaUtil" align="right" style="right:40px; top:18px; width:100px; border:none;" />

<br />
<br />

# JavaUtil 

<h3>Lightweight Java utilities to support straightforward development.</h3>
<h3>Java classes for the daily demands in practice.</h3>

[![Maintenance Status](https://badgen.net/badge/maintenance/active/green)](https://github.com/openworld42/JavaUtil#maintenance-status)
[![License](https://badgen.net/badge/maintenance/active/blue)](https://github.com/open42/JavaUtil/blob/main/LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](https://makeapullrequest.com) 

<br />
<br />

# JavaUtil is still in a formation process - but you can watch things grow.

<br />
<br />


Java classes for the daily demands in practice. 

**[Click here if you just want the latest release jar file.](https://github.com/openworld42/JavaTemplate/blob/master/template_v1.1.0.jar)**

**To use it:** simply copy over the files you want to use into your project and delete the methods, parts or files you don't need, or reference the **jar file** of a release. **JavaUtil** needs a Java version of **17+**.

**JavaUtil** tries to keep it simple but functional, 
thus reducing unnecessary complexity. Whenever possible, it makes use  of POJOs (Plain Old Java Object), and uses the KISS (Keep it simple [and] stupid) and "Clean Code" (easy to understand) principle. Don't repeat the boring tasks, don't re-invent the wheel. 

**JavaUtil** is not a framework, and it has **no dependencies**. You use it or modify it, possibly deleting the unnecessary parts. Use the saved time for other things you like.

### Documentation / Examples 
(what's in, how to use it, practical examples, specimen code, etc.)

*Test file contents*

```java
import org.json.JSONObject;
public class Test {
    public static void main(String args[]){
       JSONObject jo = new JSONObject("{ \"abc\" : \"def\" }");
       System.out.println(jo.toString());
    }
}
```

*Execute the Test file*

```shell 
java -cp .;json-java.jar Test (Windows)
java -cp .:json-java.jar Test (Unix Systems)
```

### Javadocs / API



**Apache 2.0 licensed**, therefore could be used in any other GPL/Apache/FOSS project.<br />

**Author**: Heinz Silberbauer  (You like it? It helped you? Spend a Github Star to motivate me :whale:)<br />
Contributions from any interested party are welcome.


<!-- Repository -->

[repo_url]: https://github.com/open42/JavaUtil
[repo_license_url]: https://github.com/open42/JavaUtil/blob/main/LICENSE
[repo_license_img]: https://img.shields.io/badge/license-Apache_2.0-red?style=for-the-badge&logo=none


