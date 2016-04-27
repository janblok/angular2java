package fr.lteconsulting.angular2gwt.client;

import fr.lteconsulting.angular2gwt.Component;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Angular component managing a list of heroes.
 * 
 * <li>It gets the {@link HeroService} injected by Angular.
 * <li>Its view template and CSS styles are loaded from external files located in webapp
 * <li>It has two methods : one for getting the data list and another to add a new hero in the database
 * <li>The {@link HeroFormComponent} is declared as a directive because it is declared in the template
 * 
 * @author Arnaud Tournier
 *         (c) LTE Consulting 2016
 */
//@formatter:off
@Component(
		selector = "hero-list",
		templateUrl = "template/hero-list.component.html",
		styleUrls = {"css/hero-list.component.css"},
		directives = {HeroFormComponent.class})
//@formatter:on
@JsType
public class HeroListComponent
{
	@JsProperty
	private Router router;

	@JsProperty
	private String title;

	@JsProperty
	private Hero selectedHero;

	@JsProperty
	private JsArray<Hero> heroes;

	@JsConstructor
	public HeroListComponent( HeroService heroService, Router router )
	{
		this.heroes = heroService.getHeroes();
		this.router = router;
	}

	@JsMethod
	protected void onSelect( Hero hero )
	{
		selectedHero = hero;
	}

	@JsMethod
	protected void gotoDetail( Hero hero )
	{
		router.navigate( JsArray.of( "HeroDetail", new LinkDto( hero.getId() ) ) );
	}
}
