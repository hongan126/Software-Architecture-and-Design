package Controller;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLConvert<T> {
	private T type;

	public XMLConvert(T type) {
		super();
		this.type = type;
	}

	@SuppressWarnings("all")
	public T XMLToObject(String xml) {
		System.out.println(xml);
		T object = null;
		JAXBContext ctx;
		try {
			ctx = JAXBContext.newInstance(type.getClass());
			Unmarshaller ms = ctx.createUnmarshaller();
			object = (T) ms.unmarshal(new StringReader(xml));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return object;
	}

	public String ObjectToXML(T obj) {
		JAXBContext ctx;
		StringWriter sw = null;
		try {
			ctx = JAXBContext.newInstance(type.getClass());
			Marshaller ms = ctx.createMarshaller();
			sw = new StringWriter();
			ms.marshal(obj, sw);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sw.toString();
	}

}
