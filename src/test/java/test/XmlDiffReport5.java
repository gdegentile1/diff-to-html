package test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import de.cronn.diff.html.FileDiffHtmlBuilder;
import de.cronn.diff.impl.java.JavaFileDiffToHtmlImpl;
import de.cronn.diff.impl.java.wrapper.JavaDiffUtils2HtmlWrapper;
import de.cronn.diff.util.DiffToHtmlParameters;
import de.cronn.diff.util.SimpleFileInfo;
import de.cronn.diff.util.DiffToHtmlParameters.DiffType;

public class XmlDiffReport5 {

//pre {
//    white-space: pre-wrap;       /* Since CSS 2.1 */
//    white-space: -moz-pre-wrap;  /* Mozilla, since 1999 */
//    white-space: -pre-wrap;      /* Opera 4-6 */
//    white-space: -o-pre-wrap;    /* Opera 7 */
//    word-wrap: break-word;       /* Internet Explorer 5.5+ */
//    overflow-wrap: anywhere;
//}

	public static void main(String[] args) throws Exception {
		
		String leftFilename   = "D:\\git\\workspace\\diff-to-html\\data\\test\\input\\xml1\\debug.xml";
		String rightFilename  = "D:\\git\\workspace\\diff-to-html\\data\\test\\input\\xml2\\debug.xml";
		String outputFilename = "D:\\git\\workspace\\diff-to-html\\data\\test\\output\\xml_out.html";
		
		String[] myArgs = {
				leftFilename, 
				rightFilename,
				outputFilename
				,"--ignore-white-spaces"
				,"--ignore-space-change"
				,"--ignore-line-endings"
				
				//,"--line-diff"
		};
		
		
		DiffToHtmlParameters parameters = DiffToHtmlParameters.builder()
				.withDiffType(DiffType.FILES)
				.withInputLeftPath(leftFilename)
				.withInputRightPath(rightFilename)
				.withOutputPath(outputFilename)
				.withIgnoreUniqueFiles(false)
				.withIgnoreWhiteSpaces(true)
				.withIgnoreSpaceChange(true)
				.withIgnoreLineEndings(true)
				.withDetectTextFileEncoding(true)
				.withOnlyReports(false)
				.withUnifiedContext(3)
				.withMaxAllowedDifferenceInByte(500000l)
				.withLinewiseDiff(false)
				.build();
		
		JavaFileDiffToHtmlImpl factory = new JavaFileDiffToHtmlImpl(parameters);
		
		FileDiffHtmlBuilder htmlBuilder = new FileDiffHtmlBuilder(parameters);
		htmlBuilder.setFileLeftInfo(new SimpleFileInfo(parameters.getInputLeftPath(), ""));
		htmlBuilder.setFileRightInfo(new SimpleFileInfo(parameters.getInputRightPath(), ""));
		
		List<String> originalLines = Files.readAllLines(Paths.get(parameters.getInputLeftPath()));
		List<String> revisedLines = Files.readAllLines(Paths.get(parameters.getInputRightPath()));

		
		String html = new JavaDiffUtils2HtmlWrapper().appendDiffToBuilder(htmlBuilder, parameters).toString();
		
		String path = parameters.getOutputPath();
		Files.write(Paths.get(path), html.getBytes());
		System.out.println("Output File: " + path);
	}
}
