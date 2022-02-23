package com.example.ecommerce;

import com.example.ecommerce.product.model.Product;
import com.example.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@SpringBootApplication
public class ECommerceApplication {

	@Autowired
	ProductRepository productRepository;

	@PostConstruct
	public void initialData() {
		/* For Product */
		Product product = new Product("ตุ๊กตาน้องหมาบลูด๊อก", "ตุ๊กตาน้องหมาบลูด๊อกตัวนุ่มนิ่ม ขนาดความสูง 35 cm สามารถถอดเปลี่ยนชุดได้", new BigDecimal(350));
		productRepository.save(product);

		product = new Product("เสื้อสำหรับตุ๊กตาน้องหมาบลูด๊อก ลายดอกไม้", "เสื้อผ้าลายดอกไม้สำหรับเปลี่ยนให้ตุ๊กตาน้องหมาบลูด๊อกสำหรับขนาดความสูง 35 ท่านั้น", new BigDecimal(79));
		productRepository.save(product);

		product = new Product("หมอนพิงหลัง แก้ออฟฟิตซินโดรม", "หมอนพิงหลัง ใช้สำหรับพิงหลัง เหมาะกับคนที่ต้องนั่งทำงานเป็นเวลานาน บรรเทาอาการปวดเมื่อยหลังได้ดี", new BigDecimal(799));
		productRepository.save(product);

		product = new Product("หมอนข้างนุ่มนิ่ม", "หมอนข้างนุ่มฟู เหมาะสำหรับคนชอบหมอนข้างนุ่มๆ กอดแล้วอบอุ่น", new BigDecimal(599));
		productRepository.save(product);

		product = new Product("ผ้าปูที่นอนเก็บความเย็น 5 ฟุต", "ผ้าปูที่นอนเก็บความเย็น เหมาะสำหรับห้องที่มีแอร์ หลังจากปิดแอร์ผ้าปูจะยังเย็น นอนสบาย", new BigDecimal(1000));
		productRepository.save(product);
	}

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

}
