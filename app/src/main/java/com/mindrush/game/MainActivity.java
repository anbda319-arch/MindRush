package com.mindrush.game;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import android.content.SharedPreferences;
import java.util.*;

public class MainActivity extends Activity {
    static class Q {
        String text; String[] a; int correct;
        Q(String text, String[] a, int correct) { this.text=text; this.a=a; this.correct=correct; }
    }

    final ArrayList<Q> bank = new ArrayList<>(Arrays.asList(
            new Q("ما عاصمة فرنسا؟", new String[]{"باريس","مدريد","روما","برلين"}, 0),
            new Q("ما أكبر كوكب في المجموعة الشمسية؟", new String[]{"الأرض","المشتري","زحل","نبتون"}, 1),
            new Q("كم عدد قارات العالم؟", new String[]{"5","6","7","8"}, 2),
            new Q("ما الكوكب المعروف بالكوكب الأحمر؟", new String[]{"الزهرة","المريخ","عطارد","أورانوس"}, 1),
            new Q("ما الغاز الضروري للتنفس عند الإنسان؟", new String[]{"الأكسجين","الهيليوم","النيون","الهيدروجين"}, 0),
            new Q("كم يومًا في السنة الميلادية العادية؟", new String[]{"360","364","365","366"}, 2),
            new Q("ما أكبر محيط على الأرض؟", new String[]{"الأطلسي","الهندي","الهادئ","المتجمد الشمالي"}, 2),
            new Q("ما أسرع حيوان بري؟", new String[]{"الفهد","الأسد","الحصان","الذئب"}, 0),
            new Q("كم ضلعًا للمثلث؟", new String[]{"2","3","4","5"}, 1),
            new Q("ما اللغة الرسمية للبرازيل؟", new String[]{"الإسبانية","البرتغالية","الفرنسية","الإنجليزية"}, 1),
            new Q("ما عاصمة مصر؟", new String[]{"القاهرة","الإسكندرية","الأقصر","أسوان"}, 0),
            new Q("ما البحر الذي يفصل أوروبا عن أفريقيا؟", new String[]{"الأحمر","المتوسط","العرب","قزوين"}, 1),
            new Q("ما وحدة قياس التيار الكهربائي؟", new String[]{"فولت","أوم","أمبير","واط"}, 2),
            new Q("ما رمز الذهب الكيميائي؟", new String[]{"Ag","Au","Fe","Gd"}, 1),
            new Q("كم لونًا في قوس قزح التقليدي؟", new String[]{"5","6","7","8"}, 2),
            new Q("من رسم الموناليزا؟", new String[]{"بيكاسو","ليوناردو دا فينشي","فان جوخ","رامبرانت"}, 1),
            new Q("ما أكبر حيوان معروف؟", new String[]{"الفيل الأفريقي","الحوت الأزرق","الزرافة","قرش الحوت"}, 1),
            new Q("كم دقيقة في الساعة؟", new String[]{"30","45","60","90"}, 2),
            new Q("ما الكوكب الأقرب إلى الشمس؟", new String[]{"عطارد","الزهرة","الأرض","المريخ"}, 0),
            new Q("ما عاصمة اليابان؟", new String[]{"كيوتو","أوساكا","طوكيو","هيروشيما"}, 2),
            new Q("ما العضو الذي يضخ الدم؟", new String[]{"الرئة","الكبد","القلب","المعدة"}, 2),
            new Q("كم عدد الأسنان الدائمة لدى البالغ عادة؟", new String[]{"28","30","32","36"}, 2),
            new Q("ما أكبر قارة مساحة؟", new String[]{"أفريقيا","آسيا","أوروبا","أمريكا الجنوبية"}, 1),
            new Q("ما أصغر قارة مساحة؟", new String[]{"أوروبا","أستراليا","أفريقيا","أمريكا الشمالية"}, 1),
            new Q("ما عاصمة إيطاليا؟", new String[]{"ميلانو","روما","نابولي","تورينو"}, 1),
            new Q("ما عاصمة أستراليا؟", new String[]{"سيدني","ملبورن","كانبيرا","بيرث"}, 2),
            new Q("أي كوكب يشتهر بحلقاته؟", new String[]{"المريخ","زحل","عطارد","الزهرة"}, 1),
            new Q("ما المعدن السائل في درجة حرارة الغرفة؟", new String[]{"الحديد","النحاس","الزئبق","الألومنيوم"}, 2),
            new Q("ما أكبر صحراء حارة؟", new String[]{"جوبي","الصحراء الكبرى","كالاهاري","أتاكاما"}, 1),
            new Q("كم لاعبًا لفريق كرة القدم داخل الملعب؟", new String[]{"9","10","11","12"}, 2),
            new Q("ما عاصمة بريطانيا؟", new String[]{"لندن","مانشستر","ليفربول","إدنبرة"}, 0),
            new Q("ما الحيوان المعروف بسفينة الصحراء؟", new String[]{"الحصان","الجمل","الفيل","الماعز"}, 1),
            new Q("ما العملية التي تصنع بها النباتات غذاءها بالضوء؟", new String[]{"التنفس","البناء الضوئي","التخمر","الهضم"}, 1),
            new Q("ما أقرب نجم إلى الأرض؟", new String[]{"الشعرى","الشمس","نجم القطب","منكب الجوزاء"}, 1),
            new Q("ما الجهاز الذي يقيس الحرارة؟", new String[]{"البارومتر","الترمومتر","البوصلة","الميزان"}, 1),
            new Q("ما عاصمة كندا؟", new String[]{"تورنتو","فانكوفر","أوتاوا","مونتريال"}, 2),
            new Q("في أي قارة تقع مصر؟", new String[]{"آسيا فقط","أفريقيا","أوروبا","أمريكا الشمالية"}, 1),
            new Q("ما أكبر قمر لزحل؟", new String[]{"تيتان","أوروبا","غانيميد","فوبوس"}, 0),
            new Q("كم كوكبًا في المجموعة الشمسية؟", new String[]{"7","8","9","10"}, 1),
            new Q("ما العنصر الأكثر وفرة في الكون؟", new String[]{"الأكسجين","الهيدروجين","الكربون","الحديد"}, 1),
            new Q("ما عاصمة ألمانيا؟", new String[]{"برلين","ميونخ","هامبورغ","فرانكفورت"}, 0),
            new Q("أي دولة تشتهر ببرج بيزا؟", new String[]{"إيطاليا","إسبانيا","اليونان","البرتغال"}, 0),
            new Q("ما أطول نهر في أفريقيا؟", new String[]{"الكونغو","النيل","النيجر","الزامبيزي"}, 1),
            new Q("ما أكبر دولة مساحة؟", new String[]{"كندا","الصين","روسيا","الولايات المتحدة"}, 2),
            new Q("ما عاصمة السعودية؟", new String[]{"جدة","الرياض","مكة","الدمام"}, 1),
            new Q("ما وحدة قياس الطاقة؟", new String[]{"جول","نيوتن","باسكال","هرتز"}, 0),
            new Q("ما وحدة قياس القوة؟", new String[]{"جول","واط","نيوتن","فولت"}, 2),
            new Q("ما سرعة الضوء التقريبية؟", new String[]{"300 ألف كم/ث","30 ألف","3 آلاف","3 ملايين"}, 0),
            new Q("ما اسم مجرتنا؟", new String[]{"أندروميدا","درب التبانة","المثلث","سحابة ماجلان"}, 1),
            new Q("ما أقسى مادة طبيعية معروفة؟", new String[]{"الذهب","الحديد","الألماس","الكوارتز"}, 2),
            new Q("ما عاصمة إسبانيا؟", new String[]{"برشلونة","مدريد","إشبيلية","فالنسيا"}, 1),
            new Q("أي حاسة ترتبط بالأنف؟", new String[]{"السمع","الشم","التذوق","اللمس"}, 1),
            new Q("ما العضوان اللذان ينقيان الدم ويصنعان البول؟", new String[]{"القلب","الكليتان","الرئتان","المعدة"}, 1),
            new Q("ما أكبر عضو في جسم الإنسان؟", new String[]{"الكبد","الجلد","الرئة","الدماغ"}, 1),
            new Q("أي فيتامين يصنعه الجسم مع التعرض للشمس؟", new String[]{"A","B12","C","D"}, 3),
            new Q("ما العملة الرسمية لليابان؟", new String[]{"الوون","اليوان","الين","الروبية"}, 2),
            new Q("ما الرياضة التي تستخدم مضربًا وكرة صفراء؟", new String[]{"التنس","السباحة","الملاكمة","الجمباز"}, 0),
            new Q("كم حلقة في شعار الأولمبياد؟", new String[]{"4","5","6","7"}, 1),
            new Q("في أي رياضة توجد الضربة القاضية؟", new String[]{"كرة القدم","الملاكمة","التنس","السباحة"}, 1),
            new Q("كم شوطًا في مباراة كرة القدم؟", new String[]{"1","2","3","4"}, 1),
            new Q("كم دقيقة في مباراة كرة القدم دون الوقت بدل الضائع؟", new String[]{"60","75","90","120"}, 2),
            new Q("ما الرياضة التي تُلعب على طاولة بشبكة صغيرة؟", new String[]{"تنس الطاولة","الجولف","الكريكيت","الرغبي"}, 0),
            new Q("ما البطولة العالمية لمنتخبات كرة القدم؟", new String[]{"دوري الأبطال","كأس العالم","كأس السوبر","كأس القارات"}, 1),
            new Q("ما سبب تعاقب الليل والنهار؟", new String[]{"دوران الأرض حول نفسها","دوران القمر","دوران الشمس حول الأرض","ميل القمر"}, 0),
            new Q("ما سبب الفصول الأربعة أساسًا؟", new String[]{"دوران القمر","ميل محور الأرض مع دورانها حول الشمس","تغير حجم الشمس","قرب القمر"}, 1),
            new Q("ما صيغة الماء الكيميائية؟", new String[]{"CO2","H2O","O2","NaCl"}, 1),
            new Q("ما الغاز الذي تستخدمه النباتات في البناء الضوئي؟", new String[]{"الأكسجين","ثاني أكسيد الكربون","النيتروجين","الهيدروجين"}, 1),
            new Q("ما أكثر غاز في الغلاف الجوي؟", new String[]{"الأكسجين","النيتروجين","ثاني أكسيد الكربون","الهيدروجين"}, 1),
            new Q("ما الطبقة التي تحمينا من جزء كبير من الأشعة فوق البنفسجية؟", new String[]{"الأوزون","الحديد","النيتروجين","السحب"}, 0),
            new Q("ما القوة التي تجذب الأجسام نحو الأرض؟", new String[]{"الاحتكاك","الجاذبية","المغناطيسية","الطفو"}, 1),
            new Q("ما الأداة التي تحدد الاتجاهات؟", new String[]{"البوصلة","الترمومتر","البارومتر","المجهر"}, 0),
            new Q("ما الأداة التي تكبر الأجسام الدقيقة؟", new String[]{"التلسكوب","المجهر","البوصلة","الميزان"}, 1),
            new Q("ما الأداة التي نرى بها الأجرام البعيدة؟", new String[]{"المجهر","التلسكوب","البارومتر","السونار"}, 1),
            new Q("كم شهرًا في السنة؟", new String[]{"10","11","12","13"}, 2),
            new Q("كم ساعة في اليوم؟", new String[]{"12","18","24","36"}, 2),
            new Q("كم ثانية في الدقيقة؟", new String[]{"30","45","60","90"}, 2),
            new Q("ما اللون الناتج من مزج الأزرق والأصفر في الرسم؟", new String[]{"الأخضر","البنفسجي","البرتقالي","الوردي"}, 0),
            new Q("ما أصغر وحدة بنائية للعنصر؟", new String[]{"الذرة","الخلية","النسيج","العضو"}, 0),
            new Q("ما الوحدة الأساسية للحياة؟", new String[]{"الذرة","الخلية","العضو","النسيج"}, 1),
            new Q("ما أكبر كوكب صخري؟", new String[]{"الأرض","المريخ","الزهرة","عطارد"}, 0),
            new Q("أي كوكب هو الأكثر حرارة عادةً؟", new String[]{"عطارد","الزهرة","المريخ","الأرض"}, 1),
            new Q("ما القمر الطبيعي للأرض؟", new String[]{"القمر","تيتان","أوروبا","فوبوس"}, 0),
            new Q("ما الجهاز الذي يسجل الزلازل؟", new String[]{"مقياس الزلازل","البوصلة","البارومتر","الترمومتر"}, 0),
            new Q("ما الصخور الناتجة عن تبرد الصهارة؟", new String[]{"رسوبية","نارية","متحولة","عضوية"}, 1),
            new Q("ما تحول الماء من سائل إلى غاز؟", new String[]{"التجمد","التبخر","التكاثف","الانصهار"}, 1),
            new Q("ما تحول بخار الماء إلى سائل؟", new String[]{"التكاثف","التبخر","التسامي","التجمد"}, 0),
            new Q("ما تحول الماء من سائل إلى صلب؟", new String[]{"التجمد","التبخر","الانصهار","التكاثف"}, 0),
            new Q("ما الجهاز الذي يقيس ضغط الهواء؟", new String[]{"البارومتر","الترمومتر","البوصلة","مقياس الزلازل"}, 0),
            new Q("أي الثدييات التالية يبيض؟", new String[]{"الخفاش","منقار البط","الدلفين","الحصان"}, 1),
            new Q("ما أكبر الثدييات؟", new String[]{"الفيل","الحوت الأزرق","وحيد القرن","الزرافة"}, 1),
            new Q("أي طائر لا يستطيع الطيران ويعيش في القارة القطبية؟", new String[]{"النسر","البطريق","الصقر","الببغاء"}, 1),
            new Q("أي حيوان يشتهر بتغيير لون جلده للتمويه؟", new String[]{"الحرباء","الحصان","الفيل","الدب"}, 0),
            new Q("ما أكبر حيوان بري؟", new String[]{"الزرافة","الفيل الأفريقي","وحيد القرن","فرس النهر"}, 1),
            new Q("ما الحيوان صاحب الخرطوم الطويل؟", new String[]{"الفيل","الأسد","الكنغر","الدب"}, 0),
            new Q("ما الحيوان المعروف ثقافيًا بملك الغابة؟", new String[]{"النمر","الأسد","الفهد","الذئب"}, 1),
            new Q("ما أسرع طائر معروف في الانقضاض؟", new String[]{"الصقر الشاهين","النعامة","البطريق","الطاووس"}, 0),
            new Q("ما الحيوان الذي يخزن الدهون في سنامه؟", new String[]{"الجمل","الحصان","الماعز","الغزال"}, 0),
            new Q("ما عاصمة المغرب؟", new String[]{"الدار البيضاء","مراكش","الرباط","فاس"}, 2),
            new Q("ما عاصمة الجزائر؟", new String[]{"وهران","الجزائر","قسنطينة","عنابة"}, 1),
            new Q("ما عاصمة تونس؟", new String[]{"صفاقس","سوسة","تونس","بنزرت"}, 2),
            new Q("ما عاصمة الأردن؟", new String[]{"عمّان","العقبة","إربد","الزرقاء"}, 0),
            new Q("ما عاصمة الإمارات؟", new String[]{"دبي","الشارقة","أبوظبي","العين"}, 2),
            new Q("ما عاصمة العراق؟", new String[]{"البصرة","بغداد","الموصل","أربيل"}, 1),
            new Q("ما عاصمة سوريا؟", new String[]{"حلب","حمص","دمشق","اللاذقية"}, 2),
            new Q("ما عاصمة لبنان؟", new String[]{"طرابلس","صيدا","بيروت","زحلة"}, 2),
            new Q("ما عاصمة السودان؟", new String[]{"بورتسودان","الخرطوم","الأبيض","كسلا"}, 1),
            new Q("ما عاصمة ليبيا؟", new String[]{"بنغازي","طرابلس","مصراتة","سبها"}, 1),
            new Q("ما عاصمة موريتانيا؟", new String[]{"نواكشوط","نواذيبو","أطار","روصو"}, 0),
            new Q("ما عاصمة الصومال؟", new String[]{"هرجيسا","مقديشو","بوصاصو","كيسمايو"}, 1),
            new Q("ما عاصمة إثيوبيا؟", new String[]{"أديس أبابا","ديرة داوا","بحر دار","جوندر"}, 0),
            new Q("ما العملة الرسمية لبريطانيا؟", new String[]{"اليورو","الجنيه الإسترليني","الدولار","الفرنك"}, 1),
            new Q("ما العملة الرسمية للولايات المتحدة؟", new String[]{"الدولار","اليورو","الجنيه","البيزو"}, 0),
            new Q("ما عاصمة الصين؟", new String[]{"شنغهاي","بكين","قوانغتشو","شنتشن"}, 1),
            new Q("ما عاصمة الهند؟", new String[]{"مومباي","نيودلهي","بنغالور","كولكاتا"}, 1),
            new Q("ما عاصمة روسيا؟", new String[]{"سانت بطرسبرغ","موسكو","قازان","سوتشي"}, 1),
            new Q("ما عاصمة تركيا؟", new String[]{"إسطنبول","أنقرة","إزمير","بورصة"}, 1),
            new Q("ما عاصمة اليونان؟", new String[]{"أثينا","سالونيك","كريت","باتراس"}, 0),
            new Q("ما عاصمة البرتغال؟", new String[]{"بورتو","لشبونة","براغا","فارو"}, 1),
            new Q("ما عاصمة هولندا؟", new String[]{"روتردام","أمستردام","لاهاي","أوترخت"}, 1),
            new Q("ما عاصمة النمسا؟", new String[]{"سالزبورغ","فيينا","غراتس","لينتس"}, 1),
            new Q("ما عاصمة السويد؟", new String[]{"غوتنبرغ","ستوكهولم","مالمو","أوبسالا"}, 1),
            new Q("ما عاصمة النرويج؟", new String[]{"أوسلو","بيرغن","تروندهايم","ستافنغر"}, 0),
            new Q("ما عاصمة الأرجنتين؟", new String[]{"قرطبة","بوينس آيرس","مندوزا","روزاريو"}, 1),
            new Q("ما عاصمة البرازيل؟", new String[]{"ريو دي جانيرو","برازيليا","ساو باولو","سالڤادور"}, 1),
            new Q("ما عاصمة المكسيك؟", new String[]{"مونتيري","مكسيكو سيتي","كانكون","غوادالاخارا"}, 1),
            new Q("ما أكبر محيط؟", new String[]{"الأطلسي","الهادئ","الهندي","المتجمد الجنوبي"}, 1),
            new Q("ما أصغر محيط؟", new String[]{"الهندي","المتجمد الشمالي","الأطلسي","الهادئ"}, 1),
            new Q("ما أعلى جبل فوق سطح البحر؟", new String[]{"إيفرست","كي 2","كليمنجارو","مون بلان"}, 0),
            new Q("ما أطول سلسلة جبلية على اليابسة؟", new String[]{"الألب","الأنديز","الهيمالايا","الروكي"}, 1),
            new Q("ما أكبر جزيرة في العالم؟", new String[]{"مدغشقر","جرينلاند","بورنيو","بريطانيا"}, 1),
            new Q("ما القارة التي تضم أكبر عدد من الدول؟", new String[]{"أوروبا","أفريقيا","آسيا","أمريكا الجنوبية"}, 1),
            new Q("ما البحر الأحمر يقع بين أي منطقتين رئيسيتين؟", new String[]{"أفريقيا وشبه الجزيرة العربية","أوروبا وآسيا","أمريكا وأوروبا","أستراليا وآسيا"}, 0),
            new Q("ما اسم القارة المتجمدة الجنوبية؟", new String[]{"أنتاركتيكا","أوروبا","أوقيانوسيا","آسيا"}, 0),
            new Q("ما اسم العملية التي تتحول فيها المادة الصلبة إلى سائل؟", new String[]{"التجمد","الانصهار","التبخر","التكاثف"}, 1),
            new Q("ما وحدة قياس التردد؟", new String[]{"هرتز","نيوتن","جول","باسكال"}, 0),
            new Q("ما وحدة قياس المقاومة الكهربائية؟", new String[]{"أوم","أمبير","فولت","واط"}, 0),
            new Q("ما وحدة قياس القدرة الكهربائية؟", new String[]{"واط","جول","نيوتن","هرتز"}, 0),
            new Q("ما القانون الذي يربط الجهد والتيار والمقاومة؟", new String[]{"قانون نيوتن","قانون أوم","قانون بويل","قانون باسكال"}, 1),
            new Q("ما اسم العلم الذي يدرس الكائنات الحية؟", new String[]{"الجيولوجيا","الأحياء","الفلك","الكيمياء"}, 1),
            new Q("ما العلم الذي يدرس النجوم والكواكب؟", new String[]{"الأحياء","الفلك","الجيولوجيا","الاقتصاد"}, 1),
            new Q("ما العلم الذي يدرس المادة وتفاعلاتها؟", new String[]{"الكيمياء","التاريخ","الجغرافيا","علم الاجتماع"}, 0),
            new Q("ما العلم الذي يدرس الأرض وصخورها؟", new String[]{"الجيولوجيا","الفلك","الأحياء","اللغات"}, 0),
            new Q("ما اسم الكتابة التي يستخدمها المكفوفون للقراءة باللمس؟", new String[]{"برايل","مورس","لاتين","هيروغليفية"}, 0),
            new Q("ما النظام الذي يحول النص إلى نقاط بارزة للمكفوفين؟", new String[]{"برايل","مورس","ثنائي","روماني"}, 0),
            new Q("ما الذي يقيسه البارومتر؟", new String[]{"درجة الحرارة","ضغط الهواء","السرعة","الرطوبة"}, 1),
            new Q("ما الذي تقيسه الرطوبة؟", new String[]{"كمية بخار الماء في الهواء","ضغط الهواء","سرعة الرياح","الحرارة فقط"}, 0),
            new Q("ما الجهاز الذي يقيس سرعة الرياح؟", new String[]{"الأنيمومتر","البارومتر","الترمومتر","البوصلة"}, 0),
            new Q("ما اسم الطبقة الخارجية الصلبة للأرض؟", new String[]{"القشرة","الوشاح","النواة","الغلاف الجوي"}, 0),
            new Q("ما الجزء المركزي من الذرة؟", new String[]{"النواة","الإلكترون","الفوتون","الجزيء"}, 0),
            new Q("ما الجسيم ذو الشحنة السالبة؟", new String[]{"البروتون","النيوترون","الإلكترون","النواة"}, 2),
            new Q("ما الجسيم الذي لا يحمل شحنة كهربائية؟", new String[]{"البروتون","النيوترون","الإلكترون","الأيون"}, 1),
            new Q("ما الجسيم ذو الشحنة الموجبة؟", new String[]{"الإلكترون","النيوترون","البروتون","الفوتون"}, 2),
            new Q("ما الرقم الذي يمثل الماء المتعادل تقريبًا على مقياس pH؟", new String[]{"3","5","7","10"}, 2),
            new Q("ما الغاز الذي تطلقه النباتات غالبًا أثناء البناء الضوئي؟", new String[]{"الأكسجين","النيتروجين","الهيدروجين","الميثان"}, 0),
            new Q("ما المادة التي تعطي الفلفل الحار طعمه الحار؟", new String[]{"الكافيين","الكابسيسين","الكلوروفيل","اللاكتوز"}, 1),
            new Q("ما السكر الرئيسي الموجود في الحليب؟", new String[]{"الجلوكوز","اللاكتوز","الفركتوز","السكروز"}, 1),
            new Q("ما الفاكهة التي تشتهر باحتوائها على البوتاسيوم؟", new String[]{"الموز","الليمون","العنب","الفراولة"}, 0),
            new Q("ما المشروب الذي يُصنع من حبوب البن؟", new String[]{"الشاي","القهوة","الكاكاو","العصير"}, 1)
    ));
    final Random random = new Random();
    SharedPreferences save;
    LinearLayout content;
    int stage=1, question=0, score=0, correctCount=0;
    ArrayList<Q> round = new ArrayList<>();
    CountDownTimer timer;
    boolean answered=false;

    final int BG=Color.rgb(7,8,18), PANEL=Color.rgb(20,22,36);
    final int GREEN=Color.rgb(72,230,45), BLUE=Color.rgb(35,185,255);
    final int PURPLE=Color.rgb(160,65,255), GOLD=Color.rgb(255,175,20);

    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        save=getSharedPreferences("sef_tasty_save",MODE_PRIVATE);
        stage=Math.max(1,Math.min(100,save.getInt("stage",1)));
        score=save.getInt("score",0);
        home();
    }

    GradientDrawable shape(int color) {
        GradientDrawable g=new GradientDrawable();
        g.setColor(PANEL); g.setCornerRadius(28); g.setStroke(3,color); return g;
    }
    TextView text(String s,float size,int color) {
        TextView t=new TextView(this); t.setText(s); t.setTextSize(size);
        t.setTextColor(color); t.setGravity(Gravity.CENTER); t.setPadding(12,10,12,10); return t;
    }
    Button button(String s,int color) {
        Button b=new Button(this); b.setText(s); b.setTextSize(18); b.setTextColor(Color.WHITE);
        b.setAllCaps(false); b.setBackground(shape(color));
        LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(-1,68);
        p.setMargins(12,7,12,7); b.setLayoutParams(p); return b;
    }
    void base() {
        if(timer!=null) timer.cancel();
        LinearLayout root=new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(BG);
        ScrollView sc=new ScrollView(this);
        content=new LinearLayout(this); content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(8,18,8,25); sc.addView(content);
        root.addView(sc,new LinearLayout.LayoutParams(-1,0,1));
        setContentView(root);
    }

    void home() {
        base();
        TextView logo=text("👨‍🍳\nSEF\nTASTY",40,Color.WHITE); logo.setTypeface(null,1);
        content.addView(logo,new LinearLayout.LayoutParams(-1,210));
        content.addView(text("معلومات عامة • 100 مرحلة • 10 أسئلة في كل مرحلة",16,Color.LTGRAY));
        content.addView(text("المرحلة الحالية: "+stage+" / 100\n⭐ "+score+" نقطة",20,GOLD));

        Button play=button("▶ ابدأ اللعب",GREEN); play.setOnClickListener(v->start(stage)); content.addView(play);
        Button levels=button("▦ المراحل",PURPLE); levels.setOnClickListener(v->levels()); content.addView(levels);
        Button reset=button("↻ إعادة البداية",BLUE); reset.setOnClickListener(v->{
            save.edit().clear().apply(); stage=1; score=0; home();
        }); content.addView(reset);
    }

    void levels() {
        base(); content.addView(text("المراحل 1 - 100",30,Color.WHITE));
        for(int i=1;i<=100;i++) {
            final int s=i; boolean open=i<=stage;
            Button b=button((i<stage?"✓ ":i==stage?"▶ ":"🔒 ")+"المرحلة "+i,open?GREEN:Color.DKGRAY);
            b.setEnabled(open); b.setOnClickListener(v->start(s)); content.addView(b);
        }
        Button back=button("← الرئيسية",BLUE); back.setOnClickListener(v->home()); content.addView(back);
    }

    void start(int s) {
        stage=s; question=0; correctCount=0; answered=false;
        ArrayList<Q> copy=new ArrayList<>(bank); Collections.shuffle(copy,random);
        round.clear();
        for(int i=0;i<10;i++) round.add(copy.get(i%copy.size()));
        showQuestion();
    }

    void showQuestion() {
        base(); answered=false;
        LinearLayout top=new LinearLayout(this); top.setGravity(Gravity.CENTER);
        TextView a=text("المرحلة "+stage+"/100",18,Color.WHITE);
        TextView tm=text("15",20,GOLD);
        top.addView(a,new LinearLayout.LayoutParams(0,60,1));
        top.addView(tm,new LinearLayout.LayoutParams(80,60)); content.addView(top);
        content.addView(text("⭐ "+score+"     السؤال "+(question+1)+"/10",17,GOLD));

        Q q=round.get(question);
        TextView qt=text(q.text,25,Color.WHITE); qt.setBackground(shape(BLUE));
        content.addView(qt,new LinearLayout.LayoutParams(-1,175));
        int[] colors={GREEN,BLUE,PURPLE,GOLD};
        for(int i=0;i<4;i++) {
            final int c=i; Button b=button((i+1)+"  "+q.a[i],colors[i]);
            b.setOnClickListener(v->answer(c,tm)); content.addView(b);
        }

        timer=new CountDownTimer(60000,1000) {
            public void onTick(long ms) { tm.setText(String.valueOf((ms+999)/1000)); }
            public void onFinish() { if(!answered) answer(-1,tm); }
        }.start();
    }

    
void playAnswerSound(boolean correct) {
    boolean enabled = getSharedPreferences("settings", MODE_PRIVATE)
            .getBoolean("sound", true);

    if (!enabled) return;

    android.media.MediaPlayer player =
            android.media.MediaPlayer.create(
                    this,
                    correct ? R.raw.correct : R.raw.wrong
            );
w
    if (player == null) return;

    player.setVolume(1.0f, 1.0f);

    player.setOnCompletionListener(mp -> {
        mp.release();
    });

    player.start();
}


void toggleSound() {
    android.content.SharedPreferences sp =
            getSharedPreferences("settings", MODE_PRIVATE);

    boolean current = sp.getBoolean("sound", true);

    sp.edit().putBoolean("sound", !current).apply();

    android.widget.Toast.makeText(
            this,
            !current ? "🔊 الصوت تشغيل" : "🔇 الصوت إلغاء",
            android.widget.Toast.LENGTH_SHORT
    ).show();
}

void answer(int choice, TextView tm) {
    if(answered) return;

    answered = true;

    if(timer != null) timer.cancel();

    Q q = round.get(question);
    boolean ok = choice == q.correct;

    if(ok) {
        correctCount++;
        score += 10 + Integer.parseInt(tm.getText().toString());
        playAnswerSound(true);

        android.widget.Toast.makeText(
                this,
                "✅ إجابة صحيحة!",
                android.widget.Toast.LENGTH_SHORT
        ).show();

    } else {
        playAnswerSound(false);

        android.widget.Toast.makeText(
                this,
                "❌ إجابة غلط!",
                android.widget.Toast.LENGTH_SHORT
        ).show();
    }

    question++;

    new Handler().postDelayed(() -> {
        if(question < 10) {
            showQuestion();
        } else {
            finishStage();
        }
    }, 650);
}

    void finishStage() {
        save.edit().putInt("score",score).apply();
        boolean passed=correctCount>=7;
        if(passed && stage<100) { stage++; save.edit().putInt("stage",stage).apply(); }
        base();
        content.addView(text(passed?"🏆 أحسنت!":"انتهت المرحلة",31,passed?GREEN:GOLD));
        content.addView(text("الإجابات الصحيحة: "+correctCount+" / 10",23,Color.WHITE));
        content.addView(text("⭐ إجمالي النقاط: "+score,20,GOLD));
        content.addView(text(passed?(stage==100?"🎉 أنهيت الـ100 مرحلة!":"✓ المرحلة التالية مفتوحة"):"تحتاج 7 إجابات صحيحة لفتح المرحلة التالية",18,Color.LTGRAY));
        if(passed && stage<100){ Button n=button("▶ المرحلة "+stage,GREEN); n.setOnClickListener(v->start(stage)); content.addView(n); }
        Button again=button("↻ إعادة المرحلة",PURPLE); again.setOnClickListener(v->start(Math.min(stage,100))); content.addView(again);
        Button h=button("← الرئيسية",BLUE); h.setOnClickListener(v->home()); content.addView(h);
    }
}
