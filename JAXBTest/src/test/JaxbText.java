//package test;
//
//public class JaxbText {
//
//    public void marshalTest() {
//        try {
//            Person person = new Person("jaxb", "jaxb@hello.com");
//
//            // JAXBContext 생성 & marshaller 생성
//            JAXBContext context = JAXBContext.newInstance(Person.class);
//            Marshaller marshaller = context.createMarshaller();
//
//            // 보기 좋게 출력해주는 옵션
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            // 표준 출력으로 결과를 보여준다.
//            marshaller.marshal(person, System.out);
//        } catch (Exception e) {
//            // ... handle exception
//        }
//    }
//
//    public static void main(String[] args) {
//        new JaxbText().marshalTest();
//    }
//}