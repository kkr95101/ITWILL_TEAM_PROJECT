package com.danaga.controller;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danaga.entity.Statistic;
import com.danaga.repository.StatisticRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ExcelController {
	@Autowired
	private StatisticRepository statisticRepository;

	@PostMapping("/admin/get_data")
	@ResponseBody
	public void downloadExcel(@RequestParam("param") String param, HttpServletResponse response) throws IOException {
		// DB에서 데이터 가져오기 (예시)
		List<Statistic> data = statisticRepository.findByIdStartsWith(param); // 원하는 쿼리로 데이터 가져오기

		// 엑셀 파일 생성
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Data");

		int rowNum = 0;
		for (Statistic entity : data) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(entity.getId());
			row.createCell(1).setCellValue(entity.getDailySalesTotQty());
			row.createCell(2).setCellValue(entity.getDailySalesRevenue());
			row.createCell(3).setCellValue(entity.getDailyNewMember());
			row.createCell(4).setCellValue(entity.getDailyBoardInquiry());
		}

		// HTTP 응답 설정
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=data.xlsx");

		// 엑셀 파일을 HTTP 응답으로 전송
		workbook.write(response.getOutputStream());
		workbook.close();
	}

}
