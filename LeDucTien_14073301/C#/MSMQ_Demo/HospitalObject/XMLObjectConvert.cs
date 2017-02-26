using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;
using System.IO;
namespace HospitalObject
{
    public class XMLObjectConvert<T>
    {
        public string ObjectToXML(T o)
        {
            XmlSerializer ser = new XmlSerializer(typeof(T));
            if (o == null) return null;
            string xml = "";
            using(MemoryStream ms = new MemoryStream())
            {
                ser.Serialize(ms, o);
                ms.Position = 0;
                xml = new StreamReader(ms).ReadToEnd();
            }
            return xml;
        }

        public T XMLToObject(string xml)
        {
            XmlSerializer ser = new XmlSerializer(typeof(T));
            using(MemoryStream ms = new MemoryStream())
            {
                var bytes = Encoding.UTF8.GetBytes(xml);
                ms.Write(bytes, 0, bytes.Length);
                ms.Position = 0;
                return (T) ser.Deserialize(ms);
            }
        }
    }
}
