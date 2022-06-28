<?php

namespace Facebook\WebDriver;

use Facebook\WebDriver\Remote\DesiredCapabilities;
use Facebook\WebDriver\Remote\RemoteWebDriver;

require_once('vendor/autoload.php');

// This is where Selenium server 2/3 listens by default. For Selenium 4, Chromedriver or Geckodriver, use http://localhost:4444/
$host = 'http://localhost:4444';

$capabilities = DesiredCapabilities::chrome();

$driver = RemoteWebDriver::create($host, $capabilities);

$driver->get('http://127.0.0.1:8800');
// print title of the current page to output
echo "The title is '" . $driver->getTitle() . "'\n";

// print URL of current page to output
echo "The current URL is '" . $driver->getCurrentURL() . "'\n";

$programacaoCinema = $driver->findElement(WebDriverBy::id('iFrameProgramacaoCinema'));

echo $programacaoCinema->getText() . " clicked'\n";

$programacaoCinema->click();


$nomeFilme = $driver->findElement(WebDriverBy::id('nomeFilme'));

$nomeFilme->sendKeys('Suzume no Tojimari - 2');

$faixaEtaria = $driver->findElement(WebDriverBy::id('faixaEtaria'));

$faixaEtaria->sendKeys('10');

$capacidadeSala = $driver->findElement(WebDriverBy::id('capacidadeSala'));

$capacidadeSala->sendKeys('12');

//button
$registrarFilme = $driver->findElement(WebDriverBy::id('registrarFilme'));

$registrarFilme->click();


// terminate the session and close the browser
//$driver->exit();

/*
// write 'PHP' in the search box
$driver->findElement(WebDriverBy::id('searchInput')) // find search input element
    ->sendKeys('PHP') // fill the search box
    ->submit(); // submit the whole form

// wait until 'PHP' is shown in the page heading element
$driver->wait()->until(
    WebDriverExpectedCondition::elementTextContains(WebDriverBy::id('firstHeading'), 'PHP')
);

// find element of 'History' item in menu
$historyButton = $driver->findElement(
    WebDriverBy::cssSelector('#ca-history a')
);

// read text of the element and print it to output

// click the element to navigate to revision history page
$historyButton->click();

// wait until the target page is loaded
$driver->wait()->until(
    WebDriverExpectedCondition::titleContains('Revision history')
);

// print the title of the current page
echo "The title is '" . $driver->getTitle() . "'\n";

// print the URI of the current page

echo "The current URI is '" . $driver->getCurrentURL() . "'\n";

// delete all cookies
$driver->manage()->deleteAllCookies();

// add new cookie
$cookie = new Cookie('cookie_set_by_selenium', 'cookie_value');
$driver->manage()->addCookie($cookie);

// dump current cookies to output
$cookies = $driver->manage()->getCookies();
print_r($cookies);
*/