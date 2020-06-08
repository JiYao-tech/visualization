//package com.chuweizi.script.excel;
//
//import com.poi.dome01.bean.Address;
//import com.poi.dome01.utils.JDBCUtils;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class ReadExcel {
//    public static void main(String[] args) throws IOException {
//        String path = "C:\\Users\\ZHANGFENG\\Desktop\\栗庙新村.xlsx";
//        String fileName = "Sheet1";
//        List<Address> addressList = read(path, fileName);
//        System.out.println(addressList);
//        System.out.println(addressList.size());
//        save( addressList);
//    }
//
//    public static void save(List<Address> addressList){
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
//        String sql = "insert into nb_address(fjId,jzwId,xz,communityId,responsibilityId,policeId) value (?,?,?,?,?,?)";
//        String query = "select * from nb_address";
//        List<Address> list = jdbcTemplate.query(query, new BeanPropertyRowMapper<Address>(Address.class));
//
//        Set<String> hashSet = new HashSet<String>();
//        for (int i = 0; i < list.size(); i++) {
//            hashSet.add(list.get(i).getXz());
//        }
//        for (int i = 0; i <addressList.size() ; i++) {
//            if(hashSet.add(addressList.get(i).getXz())){
//                jdbcTemplate.update(sql,addressList.get(i).getFjId(),addressList.get(i).getJzwId(),addressList.get(i).getXz(),addressList.get(i).getCommunityId(),addressList.get(i).getResponsibilityId(),addressList.get(i).getPoliceId());
//            }
//        }
//
//    }
//
//    //查询excel表中的所有数据
//    public static List<Address> read(String path,String fileName) throws IOException {
//        //读取工作簿
//        XSSFWorkbook workbook = new XSSFWorkbook(path);
//        //读取工作表
//        XSSFSheet sheet = workbook.getSheet(fileName);
//        List<Address> addressList = new ArrayList<Address>();
//        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//            //拿到每一行的数据
//            XSSFRow sheetRow = sheet.getRow(i);
//            List<String> list = new ArrayList<String>();
//            if(sheetRow!=null&&!sheetRow.equals("")){
//                for (int j = 0; j < sheetRow.getLastCellNum(); j++) {
//                    //拿到每一个单元格的数据
//                    String cellValue = sheetRow.getCell(j).getStringCellValue();
//                    if(cellValue!=null&&!cellValue.equals("")){
//                        list.add(cellValue);
//                    }
//                }
//            }
//            Address address= new Address();
//
//            for (int j = 0; j < list.size(); j++) {
//                switch (j){
//                    case 0:
//                        address.setFjId(list.get(j));
//                        break;
//                    case 1:
//                        address.setJzwId(list.get(j));
//                        break;
//                    case 2:
//                        address.setXz(list.get(j));
//                        break;
//                    case 3:
//                        address.setCommunityId(list.get(j));
//                        break;
//                    case 4:
//                        address.setResponsibilityId(list.get(j));
//                        break;
//                    case 5:
//                        address.setPoliceId(list.get(j));
//                        break;
//                }
//            }
//            addressList.add(address);
//        }
//        workbook.close();
//        return addressList;
//    }
//}
