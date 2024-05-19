package test;

public class XmlDiffReport1 {

//pre {
//    white-space: pre-wrap;       /* Since CSS 2.1 */
//    white-space: -moz-pre-wrap;  /* Mozilla, since 1999 */
//    white-space: -pre-wrap;      /* Opera 4-6 */
//    white-space: -o-pre-wrap;    /* Opera 7 */
//    word-wrap: break-word;       /* Internet Explorer 5.5+ */
//    overflow-wrap: anywhere;
//}

	public static void main(String[] args) throws Exception {
		
		String[] myArgs = {
				"D:\\git\\workspace\\diff-to-html\\data\\test\\input\\xml1\\debug.xml", 
				"D:\\git\\workspace\\diff-to-html\\data\\test\\input\\xml2\\debug.xml",
				"D:\\git\\workspace\\diff-to-html\\data\\test\\output\\xml_out.html"
				,"--ignore-white-spaces"
				,"--ignore-space-change"
				,"--ignore-line-endings"
				
				//,"--line-diff"
		};
		
		de.cronn.diff.Main.main(myArgs);
	}

}
