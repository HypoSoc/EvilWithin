package theHexaghost.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theHexaghost.GhostflameHelper;
import theHexaghost.actions.ChargeCurrentFlameAction;
import theHexaghost.actions.ExtinguishCurrentFlameAction;

public class HauntingEcho extends AbstractHexaCard {

    public final static String ID = makeID("HauntingEcho");

    //stupid intellij stuff ATTACK, SELF_AND_ENEMY, UNCOMMON

    private static final int DAMAGE = 8;
    private static final int UPG_DAMAGE = 3;

    public HauntingEcho() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.SELF_AND_ENEMY);
        baseDamage = DAMAGE;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, makeInfo(), AbstractGameAction.AttackEffect.FIRE);
        if (GhostflameHelper.activeGhostFlame.charged) {
            atb(new ExtinguishCurrentFlameAction());
            atb(new ChargeCurrentFlameAction());
        }
    }

    public void triggerOnGlowCheck() {
        this.glowColor = GhostflameHelper.activeGhostFlame.charged ? AbstractCard.GOLD_BORDER_GLOW_COLOR : AbstractCard.BLUE_BORDER_GLOW_COLOR;// 65
    }// 68

    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDamage(UPG_DAMAGE);
        }
    }
}