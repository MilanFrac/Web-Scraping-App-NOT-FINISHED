package com.example.application.views.compra;
import com.example.application.data.entity.SampleAddress;
import com.example.application.data.service.SampleAddressService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;


@PageTitle("C   O   M   P   =   R   A")
@Route(value = "")
public class COMPRAView extends Div {
    Document doc = Jsoup.connect("https://mediamarkt.pl/telefony-i-smartfony/smartfony/wszystkie-smartfony")
            .timeout(6000).get();
    Elements body = doc.select(("div.offers.is-list"));


    private final ComboBox<String> device1 = new ComboBox<>("Choose Device number 1");
    private final ComboBox<String> device2 = new ComboBox<>("Choose Device number 2");


    private final Button Compare = new Button("Compare");


    private final Binder<SampleAddress> binder = new Binder<>(SampleAddress.class);


    public COMPRAView(SampleAddressService addressService) throws IOException {
        addClassName("c-ompra-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());


        addClassNames("bg-contrast-5", "flex", "flex-col", "items-start", "p-m", "rounded-l");


        Div badge1 = new Div();
        badge1.getElement().setAttribute("theme", "badge");
        badge1.setText("Result");

        Div header1 = new Div();
        header1.addClassNames("text-xl", "font-semibold");
        header1.setText("Smartphone number 1:");


        Div header2 = new Div();
        header2.addClassNames("text-xl", "font-semibold");
        header2.setText("Smartphone number 2:");


        Paragraph description1 = new Paragraph(doc.select("div.product-attributes").get(0).text());
        description1.addClassName("my-m");
        //spróbujcie zrobić pętle do tej pętli bo przy mojej pętli wartości uciekają z headerów ;/


        Paragraph description2 = new Paragraph(doc.select("div.product-attributes").get(1).text());


        description2.addClassName("my-m");



//div.product-attribute
        add(badge1, header1, description1, header2, description2);

        Compare.addClickListener(e -> {
                    addressService.update(binder.getBean());

                    if ()
                    Notification.show("Choose two devices");
                clearForm();
        });
    };







    private Component createTitle() {

        return new H1("C   O   M   P   =   R   A");
    }
    private FormLayout createFormLayout() {
        FormLayout formLayout = new FormLayout();


            device1.setItems((doc.select("h2.title").get(0).text()));

        device2.setItems((doc.select("h2.title").get(0).text()),
                (doc.select("h2.title").get(1).text()),
                (doc.select("h2.title").get(2).text()),
                (doc.select("h2.title").get(3).text()),
                (doc.select("h2.title").get(4).text()),
                (doc.select("h2.title").get(5).text()),
                (doc.select("h2.title").get(6).text()),
                (doc.select("h2.title").get(6).text()),
                (doc.select("h2.title").get(7).text()),
                (doc.select("h2.title").get(8).text()),
                (doc.select("h2.title").get(9).text()),
                (doc.select("h2.title").get(10).text()),
                (doc.select("h2.title").get(12).text()),
                (doc.select("h2.title").get(13).text()),
                (doc.select("h2.title").get(14).text()));


       

        formLayout.add(device1, device2);
        return formLayout;
    }
    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        Compare.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(Compare);
        return buttonLayout;

    }

    private void clearForm() {
        this.binder.setBean(new SampleAddress());
    }
}




