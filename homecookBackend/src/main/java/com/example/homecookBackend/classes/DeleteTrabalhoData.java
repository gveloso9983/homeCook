package com.example.homecookBackend.classes; /**
 * Licensee: diogoferreira(Universidade do Minho)
 * License Type: Academic
 */
import com.example.homecookBackend.classes.address.Address;
import com.example.homecookBackend.classes.address.AddressDAO;
import com.example.homecookBackend.classes.baker.Baker;
import com.example.homecookBackend.classes.baker.BakerDAO;
import com.example.homecookBackend.classes.cart_line.Cart_line;
import com.example.homecookBackend.classes.cart_line.Cart_lineDAO;
import com.example.homecookBackend.classes.category.Category;
import com.example.homecookBackend.classes.category.CategoryDAO;
import com.example.homecookBackend.classes.client.Client;
import com.example.homecookBackend.classes.client.ClientDAO;
import com.example.homecookBackend.classes.comment.Comment;
import com.example.homecookBackend.classes.comment.CommentDAO;
import com.example.homecookBackend.classes.image.Image;
import com.example.homecookBackend.classes.image.ImageDAO;
import com.example.homecookBackend.classes.invoice.Invoice;
import com.example.homecookBackend.classes.invoice.InvoiceDAO;
import com.example.homecookBackend.classes.invoice_line.Invoice_line;
import com.example.homecookBackend.classes.invoice_line.Invoice_lineDAO;
import com.example.homecookBackend.classes.product.Product;
import com.example.homecookBackend.classes.product.ProductDAO;
import org.orm.*;
public class DeleteTrabalhoData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = TrabalhoPersistentManager.instance().getSession().beginTransaction();
		try {
			Client client = ClientDAO.loadClientByQuery(null, null);
			// Delete the persistent object
			ClientDAO.delete(client);
			Baker baker = BakerDAO.loadBakerByQuery(null, null);
			// Delete the persistent object
			BakerDAO.delete(baker);
			Invoice_line invoice_line = Invoice_lineDAO.loadInvoice_lineByQuery(null, null);
			// Delete the persistent object
			Invoice_lineDAO.delete(invoice_line);
			Product product = ProductDAO.loadProductByQuery(null, null);
			// Delete the persistent object
			ProductDAO.delete(product);
			Comment comment = CommentDAO.loadCommentByQuery(null, null);
			// Delete the persistent object
			CommentDAO.delete(comment);
			Invoice invoice = InvoiceDAO.loadInvoiceByQuery(null, null);
			// Delete the persistent object
			InvoiceDAO.delete(invoice);
			Category category = CategoryDAO.loadCategoryByQuery(null, null);
			// Delete the persistent object
			CategoryDAO.delete(category);
			Address address = AddressDAO.loadAddressByQuery(null, null);
			// Delete the persistent object
			AddressDAO.delete(address);
			Cart_line cart_line = Cart_lineDAO.loadCart_lineByQuery(null, null);
			// Delete the persistent object
			Cart_lineDAO.delete(cart_line);
			Image image = ImageDAO.loadImageByQuery(null, null);
			// Delete the persistent object
			ImageDAO.delete(image);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteTrabalhoData deleteTrabalhoData = new DeleteTrabalhoData();
			try {
				deleteTrabalhoData.deleteTestData();
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
