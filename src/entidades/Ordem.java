package entidades;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.enumeracoes.OrdemStatus;

public class Ordem {

		private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		private Date moment;
		private OrdemStatus status;
		
		private Cliente cliente;
		private List<OrdemItem> items = new ArrayList<>();
		
		public Ordem(Date moment, OrdemStatus status, Cliente cliente) {
			this.moment = moment;
			this.status = status;
			this.cliente = cliente;
		}

		public Date getMoment() {
			return moment;
		}

		public void setMoment(Date moment) {
			this.moment = moment;
		}

		public OrdemStatus getStatus() {
			return status;
		}

		public void setStatus(OrdemStatus status) {
			this.status = status;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setClient(Cliente cliente) {
			this.cliente = cliente;
		}

		public List<OrdemItem> getItems() {
			return items;
		}
		
		public void addItem(OrdemItem item) {
			items.add(item);
		}

		public void removeItem(OrdemItem item) {
			items.remove(item);
		}
		
		public double total() {
			double sum = 0.0;
			for (OrdemItem item : items) {
				sum += item.subTotal();
			}
			return sum;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Momento do pedido: ");
			sb.append(sdf.format(moment) + "\n");
			sb.append("Status do pedido: ");
			sb.append(status + "\n");
			sb.append("Cliente: ");
			sb.append(cliente + "\n");
			sb.append("Status do pedido:\n");
			for (OrdemItem item : items) {
				sb.append(item + "\n");
			}
			sb.append("Preço Total : $");
			sb.append(String.format("%.2f", total()));
			return sb.toString();
		}
}
