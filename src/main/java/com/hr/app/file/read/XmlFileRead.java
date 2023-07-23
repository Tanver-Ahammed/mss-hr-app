package com.hr.app.file.read;

import com.hr.app.dao.EmployeeDao;
import com.hr.app.dao.impl.EmployeeDaoImpl;
import com.hr.app.model.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class XmlFileRead {

    public void retrieveEmpInfoSaveDB() {
        try {
            File file = new File("/home/tanver/Documents/Code/Java/Leads Project/hr-application/src/main/resources/employee.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            Document document = docBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("employee");
            EmployeeDao employeeDao = new EmployeeDaoImpl();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element empElement = (Element) node;
                    Employee employee = new Employee();
                    employee.setId(Integer.parseInt(empElement.getAttribute("id")));
                    employee.setFirstname(empElement.getElementsByTagName("firstname").item(0).getTextContent());
                    employee.setLastname(empElement.getElementsByTagName("lastname").item(0).getTextContent());
                    employee.setTitle(empElement.getElementsByTagName("title").item(0).getTextContent());
                    employee.setDivision(empElement.getElementsByTagName("division").item(0).getTextContent());
                    employee.setBuilding(Integer.parseInt(empElement.getElementsByTagName("building").item(0).getTextContent()));
                    employee.setRoom(empElement.getElementsByTagName("room").item(0).getTextContent());
                    System.out.println(employee);
                    employeeDao.saveEmployee(employee);
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String argv[]) throws SQLException {

//        new XmlFileRead().getAllEmployee();

        Employee employee = new Employee("Tanver", "Ahammed", "Java Developer", "IT", 12, "12-A");
        EmployeeDao employeeDao = new EmployeeDaoImpl();
//        employeeDao.getAllEmployee();
        employeeDao.updateEmployee(employee, 129);

    }

}
