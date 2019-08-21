package amis.camel.CamelSBTwitterWebsocketTest.routes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExampleCamelRouteTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void appointmentTest() {
        // call the REST API
        ResponseEntity<String> response = restTemplate.getForEntity("/tmf-api/appointment/v1/searchTimeSlot", String.class);
        // check if Http respons status is matching
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        // check if respons body is matching
        String responseBody = response.getBody();
        assertThat(responseBody.equals(
                "{\n" +
                        "    id: 2795673\n" +
                        "    href: null\n" +
                        "    externalId: ADT_NL_1078625\n" +
                        "    description: Storing op locatie\n" +
                        "    category: null\n" +
                        "    status: null\n" +
                        "    creationDate: 2019-04-08T06:00Z\n" +
                        "    lastUpdate: null\n" +
                        "    validFor: class TimePeriodResponse {\n" +
                        "        startDateTime: 2019-05-01T12:00Z\n" +
                        "        endDateTime: 2019-05-01T17:00Z\n" +
                        "        onsiteTime: null\n" +
                        "    }\n" +
                        "    baseType: null\n" +
                        "    type: null\n" +
                        "    schemaLocation: null\n" +
                        "    attachment: null\n" +
                        "    calendarEvent: null\n" +
                        "    relatedParty: [class RelatedPartyRef {\n" +
                        "        id: 9615714\n" +
                        "        href: null\n" +
                        "        name: Upellite D4ajibu Upellite D4ajibu\n" +
                        "        role: null\n" +
                        "        referredType: null\n" +
                        "    }]\n" +
                        "    place: class Place {\n" +
                        "        id: 0\n" +
                        "        href: null\n" +
                        "        name: null\n" +
                        "        role: null\n" +
                        "        referredType: null\n" +
                        "        schemaLocation: null\n" +
                        "        address: class Address {\n" +
                        "            streetName: GEBROEDERS MARISLAAN\n" +
                        "            postCode: 1394ED\n" +
                        "            city: Nederhorst den Berg\n" +
                        "            country: NL\n" +
                        "            houseExt: 18\n" +
                        "            houseNr: null\n" +
                        "        }\n" +
                        "        geographicLocation: null\n" +
                        "        region: null\n" +
                        "    }\n" +
                        "    contactMedium: class ContactMedium {\n" +
                        "        characteristic: class MediumCharacteristic {\n" +
                        "            phoneNumber: 0677889966\n" +
                        "            emailAddress: null\n" +
                        "            type: null\n" +
                        "            schemaLocation: null\n" +
                        "            mobileNumber: null\n" +
                        "        }\n" +
                        "    }\n" +
                        "    relatedEntity: null\n" +
                        "    note: null\n" +
                        "    priority: null\n" +
                        "}\n"));
    }

}