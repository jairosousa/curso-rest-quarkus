package io.github.jairosousa;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

import javax.ws.rs.core.Application;

/**
 * @Autor Jairo Nascimento
 * @Created 21/11/2021 - 11:00
 */
@OpenAPIDefinition(
        info = @Info(
                title="API Quarkus Social",
                version = "1.0",
                contact = @Contact(
                        name = "JNS Dev Support",
                        url = "https://jairosousa.github.io/",
                        email = "techsupport@jairosousa.github.io"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class QuarkusSocialApplications extends Application {
}
