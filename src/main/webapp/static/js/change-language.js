function changeLanguageTo(locale) {
    console.log(1)
    document.cookie = `lang=${locale}`;
    document.location.reload();
}