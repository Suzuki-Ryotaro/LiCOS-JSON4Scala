package licos.knowledge

import licos.protocol.element.village.part.NameProtocol
import licos.util.WerewolfWorld

sealed abstract class Character(val name: NameProtocol) {
  private var id: Int = -1

  def getId: Int = id

  def setId(id: Int): Character = {
    this.id = id
    this
  }

  def icon: String = WerewolfWorld.characterIcon(name.en.head.toString.toLowerCase)

  override def equals(o: Any): Boolean = {
    o match {
      case character: Character => this.name.en == character.name.en
      case _ => false
    }
  }

  override def toString: String = name.en
}

final case class Adil()
    extends Character(
      NameProtocol()
        .ar("Adil")
        .de("Adil")
        .en("Adil")
        .es("Adil")
        .it("Adil")
        .fr("Adil")
        .ja("アーディル")
        .pt("Adil")
        .ru("Адил")
        .uk("Адил")
        .vi("Adil")
        .zhCN("Adil")
        .zhTW("Adil")
    )

final case class Borya()
    extends Character(
      NameProtocol()
        .ar("Borya")
        .de("Borya")
        .en("Borya")
        .es("Borya")
        .it("Borya")
        .fr("Borya")
        .ja("ボーリャ")
        .pt("Borya")
        .ru("Боря")
        .uk("Боря")
        .vi("Borya")
        .zhCN("Borya")
        .zhTW("Borya")
    )

final case class Chacha()
    extends Character(
      NameProtocol()
        .ar("Chacha")
        .de("Chacha")
        .en("Chacha")
        .es("Chacha")
        .it("Chacha")
        .fr("Chacha")
        .ja("チャチャ")
        .pt("Chacha")
        .ru("Чача")
        .uk("Чача")
        .vi("Chacha")
        .zhCN("Chacha")
        .zhTW("Chacha")
    )

final case class Devdatta()
    extends Character(
      NameProtocol()
        .ar("Devdatta")
        .de("Devdatta")
        .en("Devdatta")
        .es("Devdatta")
        .it("Devdatta")
        .fr("Devdatta")
        .ja("デヴゥダッタ")
        .pt("Devdatta")
        .ru("Девдатта")
        .uk("Девдатта")
        .vi("Devdatta")
        .zhCN("Devdatta")
        .zhTW("Devdatta")
    )

final case class Ekrem()
    extends Character(
      NameProtocol()
        .ar("Ekrem")
        .de("Ekrem")
        .en("Ekrem")
        .es("Ekrem")
        .it("Ekrem")
        .fr("Ekrem")
        .ja("エクレム")
        .pt("Ekrem")
        .ru("Екрем")
        .uk("Екрем")
        .vi("Ekrem")
        .zhCN("Ekrem")
        .zhTW("Ekrem")
    )

final case class Fernando()
    extends Character(
      NameProtocol()
        .ar("Fernando")
        .de("Fernando")
        .en("Fernando")
        .es("Fernando")
        .it("Fernando")
        .fr("Fernando")
        .ja("フェルナンド")
        .pt("Fernando")
        .ru("Фернандо")
        .uk("Фернандо")
        .vi("Fernando")
        .zhCN("Fernando")
        .zhTW("Fernando")
    )

final case class Gavriil()
    extends Character(
      NameProtocol()
        .ar("Gavriil")
        .de("Gavriil")
        .en("Gavriil")
        .es("Gavriil")
        .it("Gavriil")
        .fr("Gavriil")
        .ja("ガブリール")
        .pt("Gavriil")
        .ru("Гавриил")
        .uk("Гавриил")
        .vi("Gavriil")
        .zhCN("Gavriil")
        .zhTW("Gavriil")
    )

final case class Henrik()
    extends Character(
      NameProtocol()
        .ar("Henrik")
        .de("Henrik")
        .en("Henrik")
        .es("Henrik")
        .it("Henrik")
        .fr("Henrik")
        .ja("ヘンリック")
        .pt("Henrik")
        .ru("Хенрик")
        .uk("Хенрик")
        .vi("Henrik")
        .zhCN("Henrik")
        .zhTW("Henrik")
    )

final case class Ileanna()
    extends Character(
      NameProtocol()
        .ar("Ileanna")
        .de("Ileanna")
        .en("Ileanna")
        .es("Ileanna")
        .it("Ileanna")
        .fr("Ileanna")
        .ja("イレアナ")
        .pt("Ileanna")
        .ru("Илеанна")
        .uk("Илеанна")
        .vi("Ileanna")
        .zhCN("Ileanna")
        .zhTW("Ileanna")
    )

final case class Jasmin()
    extends Character(
      NameProtocol()
        .ar("Jasmin")
        .de("Jasmin")
        .en("Jasmin")
        .es("Jasmin")
        .it("Jasmin")
        .fr("Jasmin")
        .ja("ジャスミン")
        .pt("Jasmin")
        .ru("Ясмин")
        .uk("Ясмин")
        .vi("Jasmin")
        .zhCN("Jasmin")
        .zhTW("Jasmin")
    )

final case class Kaiji()
    extends Character(
      NameProtocol()
        .ar("Kaiji")
        .de("Kaiji")
        .en("Kaiji")
        .es("Kaiji")
        .it("Kaiji")
        .fr("Kaiji")
        .ja("開司")
        .pt("Kaiji")
        .ru("Каийи")
        .uk("Каийи")
        .vi("Kaiji")
        .zhCN("开司")
        .zhTW("開司")
    )

final case class Louise()
    extends Character(
      NameProtocol()
        .ar("Louise")
        .de("Louise")
        .en("Louise")
        .es("Louise")
        .it("Louise")
        .fr("Louise")
        .ja("ルイーズ")
        .pt("Louise")
        .ru("Лоуисе")
        .uk("Лоуисе")
        .vi("Louise")
        .zhCN("Louise")
        .zhTW("Louise")
    )

final case class Marthe()
    extends Character(
      NameProtocol()
        .ar("Marthe")
        .de("Marthe")
        .en("Marthe")
        .es("Marthe")
        .it("Marthe")
        .fr("Marthe")
        .ja("マーテ")
        .pt("Marthe")
        .ru("Мартхе")
        .uk("Мартхе")
        .vi("Marthe")
        .zhCN("Marthe")
        .zhTW("Marthe")
    )

final case class Nanyamka()
    extends Character(
      NameProtocol()
        .ar("Nanyamka")
        .de("Nanyamka")
        .en("Nanyamka")
        .es("Nanyamka")
        .it("Nanyamka")
        .fr("Nanyamka")
        .ja("ナニャンカ")
        .pt("Nanyamka")
        .ru("Наныамка")
        .uk("Наныамка")
        .vi("Nanyamka")
        .zhCN("Nanyamka")
        .zhTW("Nanyamka")
    )

final case class Oliwia()
    extends Character(
      NameProtocol()
        .ar("Oliwia")
        .de("Oliwia")
        .en("Oliwia")
        .es("Oliwia")
        .it("Oliwia")
        .fr("Oliwia")
        .ja("オリビア")
        .pt("Oliwia")
        .ru("Олиwиа")
        .uk("Олиwиа")
        .vi("Oliwia")
        .zhCN("Oliwia")
        .zhTW("Oliwia")
    )

final case class Ryan()
    extends Character(
      NameProtocol()
        .ar("Ryan")
        .de("Ryan")
        .en("Ryan")
        .es("Ryan")
        .it("Ryan")
        .fr("Ryan")
        .ja("ライアン")
        .pt("Ryan")
        .ru("Рыан")
        .uk("Рыан")
        .vi("Ryan")
        .zhCN("Ryan")
        .zhTW("Ryan")
    )

final case class Susan()
    extends Character(
      NameProtocol()
        .ar("Susan")
        .de("Susan")
        .en("Susan")
        .es("Susan")
        .it("Susan")
        .fr("Susan")
        .ja("スーザン")
        .pt("Susan")
        .ru("Сусан")
        .uk("Сусан")
        .vi("Susan")
        .zhCN("Susan")
        .zhTW("Susan")
    )

final case class Thuy()
    extends Character(
      NameProtocol()
        .ar("Thuy")
        .de("Thuy")
        .en("Thuy")
        .es("Thuy")
        .it("Thuy")
        .fr("Thuy")
        .ja("ティー")
        .pt("Thuy")
        .ru("Тхуы")
        .uk("Тхуы")
        .vi("Thúy")
        .zhCN("Thuy")
        .zhTW("Thuy")
    )

final case class Uma()
    extends Character(
      NameProtocol()
        .ar("Uma")
        .de("Uma")
        .en("Uma")
        .es("Uma")
        .it("Uma")
        .fr("Uma")
        .ja("ウマ")
        .pt("Uma")
        .ru("Ума")
        .uk("Ума")
        .vi("Uma")
        .zhCN("Uma")
        .zhTW("Uma")
    )

final case class Valeria()
    extends Character(
      NameProtocol()
        .ar("Valeria")
        .de("Valeria")
        .en("Valeria")
        .es("Valeria")
        .it("Valeria")
        .fr("Valeria")
        .ja("ヴァレリア")
        .pt("Valeria")
        .ru("Валериа")
        .uk("Валериа")
        .vi("Valeria")
        .zhCN("Valeria")
        .zhTW("Valeria")
    )

final case class Yihan()
    extends Character(
      NameProtocol()
        .ar("Yihan")
        .de("Yihan")
        .en("Yihan")
        .es("Yihan")
        .it("Yihan")
        .fr("Yihan")
        .ja("イーハン")
        .pt("Yihan")
        .ru("Ыихан")
        .uk("Ыихан")
        .vi("Yihan")
        .zhCN("艺涵")
        .zhTW("藝涵")
    )
