package com.dci.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.servlet.ServletContext;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.dci.common.model.ReportHeaderBean;

public class XmlDomParser {

	public static List<ReportHeaderBean> getReportHeader(ServletContext context, String xmlName) throws Exception {

		String xmlPath = "reportHeader/" + xmlName;

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SaxParseHandler parseHandler = new SaxParseHandler();
		try {
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(new InputSource(context.getClassLoader().getResourceAsStream(xmlPath)), parseHandler);
			// System.out.println("Number of read headers: " +
			// parseHandler.getHeaderDefinitons().size());
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return parseHandler.getHeaderDefinitons();
	}
}

class SaxParseHandler extends DefaultHandler {
	private static final String TAG_HEADER = "Rootheader";
	private static final String TAG_HEADERDEF = "Headerdef";
	private static final String TAG_ID = "id";
	private static final String TAG_TITLE = "title";
	private static final String TAG_DIRECTIVE = "directive";
	private static final String TAG_VISIBLE = "visible";
	private static final String TAG_ISDEFAULT = "isdefault";
	private static final String TAG_ISDRAGGABLE = "isdraggable";
	private static final String TAG_ROWSPAN = "rowspan";
	private static final String TAG_COLSPAN = "colspan";
	private static final String TAG_TYPE = "type";

	private final Stack<String> tagsStack = new Stack<String>();
	private final StringBuilder tempVal = new StringBuilder();

	private List<ReportHeaderBean> reportHeaderBeanList;
	private ReportHeaderBean reportHeaderBean;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		pushTag(qName);
		tempVal.setLength(0);
		switch (qName) {
		case TAG_HEADER:
			reportHeaderBeanList = new ArrayList<ReportHeaderBean>();
			break;
		case TAG_HEADERDEF:
			reportHeaderBean = new ReportHeaderBean();
			break;
		}
	}

	@Override
	public void characters(char ch[], int start, int length) {
		tempVal.append(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		String tag = peekTag();
		if (!qName.equals(tag)) {
			throw new InternalError();
		}

		popTag();

		String value = tempVal.toString().trim();
		switch (tag) {

		case TAG_ID:
			reportHeaderBean.setId(value);
			break;
		case TAG_TITLE:
			reportHeaderBean.setTitle(value);
			break;
		case TAG_DIRECTIVE:
			reportHeaderBean.setDirective(value);
			break;
		case TAG_VISIBLE:
			reportHeaderBean.setVisible(Boolean.parseBoolean(value));
			break;
		case TAG_ISDEFAULT:
			reportHeaderBean.setIsDefault(Boolean.parseBoolean(value));
			break;
		case TAG_ISDRAGGABLE:
			reportHeaderBean.setIsDraggable(Boolean.parseBoolean(value));
			break;
		case TAG_ROWSPAN:
			reportHeaderBean.setRowspan(value);
			break;
		case TAG_COLSPAN:
			reportHeaderBean.setColspan(value);
			break;
		case TAG_TYPE:
			reportHeaderBean.setColumnType(value);
			break;
		case TAG_HEADERDEF:
			reportHeaderBeanList.add(reportHeaderBean);
			break;
		}
	}

	@Override
	public void startDocument() {
		pushTag("");
	}

	public List<ReportHeaderBean> getHeaderDefinitons() {
		return reportHeaderBeanList;
	}

	private void pushTag(String tag) {
		tagsStack.push(tag);
	}

	private String popTag() {
		return tagsStack.pop();
	}

	private String peekTag() {
		return tagsStack.peek();
	}
}