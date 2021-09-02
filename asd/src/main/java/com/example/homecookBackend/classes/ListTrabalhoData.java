package com.example.homecookBackend.classes; /**
 * Licensee: diogoferreira(Universidade do Minho)
 * License Type: Academic
 */
import com.example.homecookBackend.classes.address.Address;
import com.example.homecookBackend.classes.address.AddressCriteria;
import com.example.homecookBackend.classes.address.AddressDAO;
import com.example.homecookBackend.classes.baker.Baker;
import com.example.homecookBackend.classes.baker.BakerCriteria;
import com.example.homecookBackend.classes.baker.BakerDAO;
import com.example.homecookBackend.classes.cart_line.Cart_line;
import com.example.homecookBackend.classes.cart_line.Cart_lineCriteria;
import com.example.homecookBackend.classes.cart_line.Cart_lineDAO;
import com.example.homecookBackend.classes.category.Category;
import com.example.homecookBackend.classes.category.CategoryCriteria;
import com.example.homecookBackend.classes.category.CategoryDAO;
import com.example.homecookBackend.classes.client.Client;
import com.example.homecookBackend.classes.client.ClientCriteria;
import com.example.homecookBackend.classes.client.ClientDAO;
import com.example.homecookBackend.classes.comment.Comment;
import com.example.homecookBackend.classes.comment.CommentCriteria;
import com.example.homecookBackend.classes.comment.CommentDAO;
import com.example.homecookBackend.classes.image.Image;
import com.example.homecookBackend.classes.image.ImageCriteria;
import com.example.homecookBackend.classes.image.ImageDAO;
import com.example.homecookBackend.classes.invoice.Invoice;
import com.example.homecookBackend.classes.invoice.InvoiceCriteria;
import com.example.homecookBackend.classes.invoice.InvoiceDAO;
import com.example.homecookBackend.classes.invoice_line.Invoice_line;
import com.example.homecookBackend.classes.invoice_line.Invoice_lineCriteria;
import com.example.homecookBackend.classes.invoice_line.Invoice_lineDAO;
import com.example.homecookBackend.classes.product.Product;
import com.example.homecookBackend.classes.product.ProductCriteria;
import com.example.homecookBackend.classes.product.ProductDAO;
import org.orm.*;

import java.util.ArrayList;

public class ListTrabalhoData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
	/*
		Product p = ProductDAO.getProductByORMID(2);
		for (Image i: p.images.toArray()) {
			p.images.remove(i);
			ImageDAO.delete(i);
		}
		Baker b = BakerDAO.getBakerByORMID(2);
		b.products.remove(p);
		ProductDAO.deleteAndDissociate(p);
		//
		//BakerDAO.save(b);


	 */

		/*
		Client c = ClientDAO.getClientByORMID(1);
		Invoice i = InvoiceDAO.createInvoice();
		Address a = AddressDAO.getAddressByORMID(2);
		i.setAddress(a);

		ArrayList<Invoice_line> linhas = new ArrayList<>();
		ArrayList<Baker> bakers = new ArrayList<>();
		for (Cart_line l: c.shopping_cart.toArray()) {
			Invoice_line il = Invoice_lineDAO.createInvoice_line();
			il.setDone(false);
			il.setQuantity(l.getQuantity());
			il.setProduct(l.getProduct());
			i.invoice_lines.add(il);

			linhas.add(il);

			l.getProduct().getBaker().orders.add(il);
			bakers.add(l.getProduct().getBaker());


		}
		c.invoices.add(i);

		ClientDAO.save(c);

		InvoiceDAO.save(i);

		for (Baker b : bakers) {
			BakerDAO.save(b);
		}
		for (Invoice_line l: linhas) {
			Invoice_lineDAO.save(l);
		}


		 */

		/*
		Product p = ProductDAO.getProductByORMID(2);
		Client c = ClientDAO.getClientByORMID(1);
		Comment com = CommentDAO.createComment();
		com.setClient(c);
		com.setComment("comentário");
		com.setScore(3);
		p.comments.add(com);
		ProductDAO.save(p);
		CommentDAO.save(com);

		 */
		//Image i = ImageDAO.createImage();
		//i.setPath("src/main/java/com/example/homecookBackend/controllers/trash.java");
		//p.images.add(i);
		//ProductDAO.save(p);
		//ImageDAO.save(i);

		Category c = CategoryDAO.createCategory();
		c.setName("Tarte");
		CategoryDAO.save(c);

		Baker b =BakerDAO.getBakerByORMID(2);

		Product p = ProductDAO.createProduct();
		p.setName("produto2");
		p.setDescription("Tarte de bolo");
		p.setPrice(10);
		p.setNumber_ratings(0);
		p.setRating(2.5F);
		p.setIngredients("ingredientes");
		p.setWeight((float) 0.9);
		p.setOnSale(true);
		p.setCategory(c);
		p.setBaker(b);


		Image i = ImageDAO.createImage();
		i.setPath("caminho/para/imagem2");

		p.images.add(i);
		ProductDAO.save(p);
		ImageDAO.save(i);



		/*
		System.out.println("Listing com.example.homecookBackend.classes.client.com.example.homecookBackend.classes.client.Client...");
		Client[] clients = ClientDAO.listClientByQuery(null, null);
		int length = Math.min(clients.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(clients[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.baker.Baker...");
		Baker[] bakers = BakerDAO.listBakerByQuery(null, null);
		length = Math.min(bakers.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(bakers[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.invoice_line.Invoice_line...");
		Invoice_line[] invoice_lines = Invoice_lineDAO.listInvoice_lineByQuery(null, null);
		length = Math.min(invoice_lines.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(invoice_lines[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.product.Product...");
		Product[] products = ProductDAO.listProductByQuery(null, null);
		length = Math.min(products.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(products[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.comment.Comment...");
		Comment[] comments = CommentDAO.listCommentByQuery(null, null);
		length = Math.min(comments.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(comments[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.invoice.Invoice...");
		Invoice[] invoices = InvoiceDAO.listInvoiceByQuery(null, null);
		length = Math.min(invoices.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(invoices[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.category.Category...");
		Category[] categorys = CategoryDAO.listCategoryByQuery(null, null);
		length = Math.min(categorys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(categorys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.address.Address...");
		Address[] addresses = AddressDAO.listAddressByQuery(null, null);
		length = Math.min(addresses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(addresses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.cart_line.Cart_line...");
		Cart_line[] cart_lines = Cart_lineDAO.listCart_lineByQuery(null, null);
		length = Math.min(cart_lines.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(cart_lines[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.image.Image...");
		Image[] images = ImageDAO.listImageByQuery(null, null);
		length = Math.min(images.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(images[i]);
		}
		System.out.println(length + " record(s) retrieved.");

		 */
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing com.example.homecookBackend.classes.client.com.example.homecookBackend.classes.client.Client by Criteria...");
		ClientCriteria clientCriteria = new ClientCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//clientCriteria.id.eq();
		clientCriteria.setMaxResults(ROW_COUNT);
		Client[] clients = clientCriteria.listClient();
		int length =clients== null ? 0 : Math.min(clients.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(clients[i]);
		}
		System.out.println(length + " com.example.homecookBackend.classes.client.com.example.homecookBackend.classes.client.Client record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.baker.Baker by Criteria...");
		BakerCriteria bakerCriteria = new BakerCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//bakerCriteria.id.eq();
		bakerCriteria.setMaxResults(ROW_COUNT);
		Baker[] bakers = bakerCriteria.listBaker();
		length =bakers== null ? 0 : Math.min(bakers.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(bakers[i]);
		}
		System.out.println(length + " com.example.homecookBackend.classes.baker.Baker record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.invoice_line.Invoice_line by Criteria...");
		Invoice_lineCriteria invoice_lineCriteria = new Invoice_lineCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//invoice_lineCriteria.id.eq();
		invoice_lineCriteria.setMaxResults(ROW_COUNT);
		Invoice_line[] invoice_lines = invoice_lineCriteria.listInvoice_line();
		length =invoice_lines== null ? 0 : Math.min(invoice_lines.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(invoice_lines[i]);
		}
		System.out.println(length + " com.example.homecookBackend.classes.invoice_line.Invoice_line record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.product.Product by Criteria...");
		ProductCriteria productCriteria = new ProductCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//productCriteria.id.eq();
		productCriteria.setMaxResults(ROW_COUNT);
		Product[] products = productCriteria.listProduct();
		length =products== null ? 0 : Math.min(products.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(products[i]);
		}
		System.out.println(length + " com.example.homecookBackend.classes.product.Product record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.comment.Comment by Criteria...");
		CommentCriteria commentCriteria = new CommentCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//commentCriteria.id.eq();
		commentCriteria.setMaxResults(ROW_COUNT);
		Comment[] comments = commentCriteria.listComment();
		length =comments== null ? 0 : Math.min(comments.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(comments[i]);
		}
		System.out.println(length + " com.example.homecookBackend.classes.comment.Comment record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.invoice.Invoice by Criteria...");
		InvoiceCriteria invoiceCriteria = new InvoiceCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//invoiceCriteria.id.eq();
		invoiceCriteria.setMaxResults(ROW_COUNT);
		Invoice[] invoices = invoiceCriteria.listInvoice();
		length =invoices== null ? 0 : Math.min(invoices.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(invoices[i]);
		}
		System.out.println(length + " com.example.homecookBackend.classes.invoice.Invoice record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.category.Category by Criteria...");
		CategoryCriteria categoryCriteria = new CategoryCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//categoryCriteria.id.eq();
		categoryCriteria.setMaxResults(ROW_COUNT);
		Category[] categorys = categoryCriteria.listCategory();
		length =categorys== null ? 0 : Math.min(categorys.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(categorys[i]);
		}
		System.out.println(length + " com.example.homecookBackend.classes.category.Category record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.address.Address by Criteria...");
		AddressCriteria addressCriteria = new AddressCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//addressCriteria.id.eq();
		addressCriteria.setMaxResults(ROW_COUNT);
		Address[] addresses = addressCriteria.listAddress();
		length =addresses== null ? 0 : Math.min(addresses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(addresses[i]);
		}
		System.out.println(length + " com.example.homecookBackend.classes.address.Address record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.cart_line.Cart_line by Criteria...");
		Cart_lineCriteria cart_lineCriteria = new Cart_lineCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//cart_lineCriteria.id.eq();
		cart_lineCriteria.setMaxResults(ROW_COUNT);
		Cart_line[] cart_lines = cart_lineCriteria.listCart_line();
		length =cart_lines== null ? 0 : Math.min(cart_lines.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(cart_lines[i]);
		}
		System.out.println(length + " com.example.homecookBackend.classes.cart_line.Cart_line record(s) retrieved.");
		
		System.out.println("Listing com.example.homecookBackend.classes.image.Image by Criteria...");
		ImageCriteria imageCriteria = new ImageCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//imageCriteria.id.eq();
		imageCriteria.setMaxResults(ROW_COUNT);
		Image[] images = imageCriteria.listImage();
		length =images== null ? 0 : Math.min(images.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(images[i]);
		}
		System.out.println(length + " com.example.homecookBackend.classes.image.Image record(s) retrieved.");
		
	}
	
	public static void main(String[] args) {
		try {
			ListTrabalhoData listTrabalhoData = new ListTrabalhoData();
			try {
				listTrabalhoData.listTestData();
				//listTrabalhoData.listByCriteria();
			}
			finally {
				TrabalhoPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
