package com.prodep.poi.export;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;


import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.StreamingOutput;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Path("/export")
public class ExportService {

	@GET
	@Path("/toExcel")
	public Response exportToExcel() {
 
		String output = "";
		String fileName = "file1";
		try {
			ExcelWorkBookUtils.createWorkBook(fileName);
			output = "Created with the file name: " + fileName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			output = "Failed to create with the file name: " + fileName;
			return Response.status(500).entity(output).build();
		}
		return Response.status(200).entity(output).build();
 
	}

	// Remove the hard coded path
	private static final String FILE_PATH = "C:\\Prodep\\file1.xlsx";


	@GET
	@Path("/get")
	@Produces("application/vnd.ms-excel")
	public Response getFile() {

		File file = new File(FILE_PATH);

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
			"attachment; filename=new-excel-file.xlsx");
		return response.build();

	}
	
	@GET
    @Path("/onlyexcel")
    @Produces("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    public StreamingOutput exportReadingsAsExcel(@Context HttpServletResponse webResponse)
    {
        final XSSFWorkbook excel = createExcel();
        webResponse.setHeader("Content-Disposition",
			"attachment; filename=SaveWithAnyName.xlsx");
<<<<<<< HEAD
        //setHeader(webResponse, "export.xlsx"); // is this required ?
=======
	// Not needed.
        //setHeader(webResponse, "export.xlsx");
>>>>>>> c481c0942151b744d11aeca9ab871bc78edf5f68
        StreamingOutput streamOutput = new StreamingOutput(){
            public void write(OutputStream output) throws IOException, WebApplicationException {
                try {
                    excel.write(output);
                } catch (Exception e) {
                    throw new WebApplicationException(e);
                }
            }
        };
        return streamOutput;
     }
	private XSSFWorkbook createExcel(){
        XSSFWorkbook excel = ExcelWorkBookUtils.createWorkBookWithData();
        try {
            ExcelOutputStream out = new ExcelOutputStream();
            excel.write(out);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(out.getBytes());
            excel = new XSSFWorkbook(inputStream);
        } catch (WebApplicationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return excel;
    }
    class ExcelOutputStream extends OutputStream {
        private ByteArrayOutputStream myByteArray;
        public ExcelOutputStream(){
            myByteArray = new ByteArrayOutputStream();
        }
        @Override
        public void write(int b) throws IOException {
            // TODO Auto-generated method stub
            myByteArray.write(b);
        }
        public byte[] getBytes(){
            return myByteArray.toByteArray();
        }
    }

}
