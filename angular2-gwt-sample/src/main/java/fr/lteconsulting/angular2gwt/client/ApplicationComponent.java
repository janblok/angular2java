package fr.lteconsulting.angular2gwt.client;

import fr.lteconsulting.angular2gwt.Component;
import fr.lteconsulting.angular2gwt.RouteConfig;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Main angular component for the application.
 * 
 * <p>
 * It simply binds to the <my-app> tag and delegates to <hero-list> tag.
 * 
 * <p>
 * It declares the {@link HeroService} as a dependency injection provider, so that it is available
 * to the child components
 * 
 * @author Arnaud Tournier
 *         (c) LTE Consulting 2016
 */
//@formatter:off
@Component(
	selector = "my-app",
	templateUrl = "template/application.component.html",
	directives = {RouterDirectives.class},
	providers = {HeroService.class, RouterProviders.class} )
@RouteConfig(
    path= "/heroes",
    name= "Heroes",
    component= HeroesComponent.class )
@RouteConfig(
	path= "/dashboard",
	name= "Dashboard",
	component= DashboardComponent.class,
	useAsDefault= true )
@RouteConfig(
	path="/detail/:id",
	name= "HeroDetail",
	component= HeroFormComponent.class)
//@formatter:on
@JsType
public class ApplicationComponent
{
	@JsProperty
	private String title = "Tour of Heroes";
}
