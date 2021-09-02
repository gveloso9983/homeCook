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
public class RetrieveAndUpdateTrabalhoData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = TrabalhoPersistentManager.instance().getSession().beginTransaction();
		try {
			Client client = ClientDAO.loadClientByQuery(null, null);
			// Update the properties of the persistent object
			ClientDAO.save(client);
			Baker baker = BakerDAO.loadBakerByQuery(null, null);
			// Update the properties of the persistent object
			BakerDAO.save(baker);
			Invoice_line invoice_line = Invoice_lineDAO.loadInvoice_lineByQuery(null, null);
			// Update the properties of the persistent object
			Invoice_lineDAO.save(invoice_line);
			Product product = ProductDAO.loadProductByQuery(null, null);
			// Update the properties of the persistent object
			ProductDAO.save(product);
			Comment comment = CommentDAO.loadCommentByQuery(null, null);
			// Update the properties of the persistent object
			CommentDAO.save(comment);
			Invoice invoice = InvoiceDAO.loadInvoiceByQuery(null, null);
			// Update the properties of the persistent object
			InvoiceDAO.save(invoice);
			Category category = CategoryDAO.loadCategoryByQuery(null, null);
			// Update the properties of the persistent object
			CategoryDAO.save(category);
			Address address = AddressDAO.loadAddressByQuery(null, null);
			// Update the properties of the persistent object
			AddressDAO.save(address);
			Cart_line cart_line = Cart_lineDAO.loadCart_lineByQuery(null, null);
			// Update the properties of the persistent object
			Cart_lineDAO.save(cart_line);
			Image image = ImageDAO.loadImageByQuery(null, null);
			// Update the properties of the persistent object
			ImageDAO.save(image);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving com.example.homecookBackend.classes.client.com.example.homecookBackend.classes.client.Client by com.example.homecookBackend.classes.client.com.example.homecookBackend.classes.client.ClientCriteria");
		ClientCriteria clientCriteria = new ClientCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//clientCriteria.id.eq();
		System.out.println(clientCriteria.uniqueClient());
		
		System.out.println("Retrieving com.example.homecookBackend.classes.baker.Baker by com.example.homecookBackend.classes.baker.BakerCriteria");
		BakerCriteria bakerCriteria = new BakerCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//bakerCriteria.id.eq();
		System.out.println(bakerCriteria.uniqueBaker());
		
		System.out.println("Retrieving com.example.homecookBackend.classes.invoice_line.Invoice_line by com.example.homecookBackend.classes.invoice_line.Invoice_lineCriteria");
		Invoice_lineCriteria invoice_lineCriteria = new Invoice_lineCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//invoice_lineCriteria.id.eq();
		System.out.println(invoice_lineCriteria.uniqueInvoice_line());
		
		System.out.println("Retrieving com.example.homecookBackend.classes.product.Product by com.example.homecookBackend.classes.product.ProductCriteria");
		ProductCriteria productCriteria = new ProductCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//productCriteria.id.eq();
		System.out.println(productCriteria.uniqueProduct());
		
		System.out.println("Retrieving com.example.homecookBackend.classes.comment.Comment by com.example.homecookBackend.classes.comment.CommentCriteria");
		CommentCriteria commentCriteria = new CommentCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//commentCriteria.id.eq();
		System.out.println(commentCriteria.uniqueComment());
		
		System.out.println("Retrieving com.example.homecookBackend.classes.invoice.Invoice by com.example.homecookBackend.classes.invoice.InvoiceCriteria");
		InvoiceCriteria invoiceCriteria = new InvoiceCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//invoiceCriteria.id.eq();
		System.out.println(invoiceCriteria.uniqueInvoice());
		
		System.out.println("Retrieving com.example.homecookBackend.classes.category.Category by com.example.homecookBackend.classes.category.CategoryCriteria");
		CategoryCriteria categoryCriteria = new CategoryCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//categoryCriteria.id.eq();
		System.out.println(categoryCriteria.uniqueCategory());
		
		System.out.println("Retrieving com.example.homecookBackend.classes.address.Address by com.example.homecookBackend.classes.address.AddressCriteria");
		AddressCriteria addressCriteria = new AddressCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//addressCriteria.id.eq();
		System.out.println(addressCriteria.uniqueAddress());
		
		System.out.println("Retrieving com.example.homecookBackend.classes.cart_line.Cart_line by com.example.homecookBackend.classes.cart_line.Cart_lineCriteria");
		Cart_lineCriteria cart_lineCriteria = new Cart_lineCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//cart_lineCriteria.id.eq();
		System.out.println(cart_lineCriteria.uniqueCart_line());
		
		System.out.println("Retrieving com.example.homecookBackend.classes.image.Image by com.example.homecookBackend.classes.image.ImageCriteria");
		ImageCriteria imageCriteria = new ImageCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//imageCriteria.id.eq();
		System.out.println(imageCriteria.uniqueImage());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateTrabalhoData retrieveAndUpdateTrabalhoData = new RetrieveAndUpdateTrabalhoData();
			try {
				retrieveAndUpdateTrabalhoData.retrieveAndUpdateTestData();
				//retrieveAndUpdateTrabalhoData.retrieveByCriteria();
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
