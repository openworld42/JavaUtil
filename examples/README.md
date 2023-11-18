
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Oxygen480-actions-office-chart-pie.svg/128px-Oxygen480-actions-office-chart-pie.svg.png" 
alt="JavaUtil" align="right" style="right:40px; top:18px; width:100px; border:none;" />

<br />

# JavaUtil 

<h3>General utility classes: overview, core utilities, simple examples</h3>



*Test file contents*

```Java
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

[Overview][examples_top_url] &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href="#top">Back to top</a>

<!-- Repository -->

[repo_url]: https://github.com/openworld42/JavaUtil
[examples_top_url]: https://github.com/openworld42/JavaUtil/tree/master/examples/README.md
[javadoc_url]: https://github.com/openworld42/JavaUtil/tree/master/javadoc/index.html

