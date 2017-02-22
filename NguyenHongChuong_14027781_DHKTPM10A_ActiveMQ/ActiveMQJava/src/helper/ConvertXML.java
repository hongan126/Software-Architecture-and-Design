package helper;

import java.io.FileInputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

import entity.BenhNhan;


public class ConvertXML<T> {

		private T type;
		
		public ConvertXML(T type) {
			this.type = type;
		}
	
		
		@SuppressWarnings("all")
		public T xml2Object(String xml) throws Exception{
			T sv=null;
			JAXBContext ctx= JAXBContext.newInstance(type.getClass());
			Unmarshaller ms = ctx.createUnmarshaller();
			sv=(T) ms.unmarshal(new StringReader(xml));
			return sv;
		}
		
		public String object2XML(T obj)throws Exception{
			JAXBContext ctx= JAXBContext.newInstance(type.getClass());
			Marshaller ms=ctx.createMarshaller();
			StringWriter sw = new StringWriter();
			ms.marshal(obj, sw);
			return sw.toString();
		}
		
		
		
//		public static void main(String[] args) throws Exception{
//			BenhNhan sv=new BenhNhan("ASDSA", "342423", "tHANH THI","SADAS 656");
//			
//			ConvertXML<BenhNhan>xs=new ConvertXML<BenhNhan>(sv);
//			String xml=xs.object2XML(sv);
//			System.out.println(xml+"\\n");
//			
//			BenhNhan ss=xs.xml2Object(xml);
//			System.out.println(ss.getMasoBN()+"\t"+ss.getHoTen());
//			
//		}
}
