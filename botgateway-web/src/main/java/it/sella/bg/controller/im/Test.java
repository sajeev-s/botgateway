package it.sella.bg.controller.im;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/t")
public class Test {

		/*@RequestMapping(value = "/u", method = RequestMethod.GET)
		public void checkBonofico(final HttpServletRequest req, HttpSession httpSession) {
			httpSession.setAttribute("Testkey", "TestValue");
			System.out.println("httpSession.getId()-->"+httpSession.getId());
			Enumeration<String> enumeration = httpSession.getAttributeNames();
			while(enumeration.hasMoreElements()){
				String name = enumeration.nextElement();
				System.out.println(name+" -- "+httpSession.getAttribute(name));
			}
			HBSessionWrapper sessionWrapper = (HBSessionWrapper)httpSession.getAttribute("HB_SESSION");
			List<Conto> conti = sessionWrapper.getHBUser().getConti();
			System.out.println("<-------- Start Conto ---------------->");
			for (Conto conto : conti) {
				System.out.println("IdConto -->"+conto.getIdConto());
				System.out.println("AliasIb -->"+conto.getAliasIb());
				System.out.println("Conto -->"+conto.getConto());
				System.out.println("###################################");
			}
			System.out.println("<-------- Stop Conto ---------------->");
			
			
			List<Carta> carte = sessionWrapper.getHBUser().getCarte();
			System.out.println("<-------- Start Carta ---------------->");
			for (Carta carta : carte) {
				System.out.println("Carta -->"+carta.getCarta());
				System.out.println("CodiceCarta -->"+carta.getCodiceCarta());
				System.out.println("ContoId -->"+carta.getContoId());
				System.out.println("###################################");
			}
			System.out.println("<-------- Stop Conto ---------------->");
		}*/
}
