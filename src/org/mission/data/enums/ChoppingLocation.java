package org.mission.data.enums;

import org.osbot.rs07.api.map.Area;
import viking.api.skills.woodcutting.enums.TreeType;

/**
 * Created by Sphiinx on 12/28/2016.
 */
public enum ChoppingLocation {

    VARROCK_WEST_1(new Area(new int[][]{
            {3171, 3424},
            {3170, 3390},
            {3157, 3387},
            {3157, 3417}
    }), false, 10, TreeType.NORMAL, TreeType.OAK),
    VARROCK_WEST_2(new Area(new int[][]{
            {3174, 3390},
            {3173, 3363},
            {3157, 3363},
            {3153, 3381},
            {3161, 3389}
    }), false, 12, TreeType.NORMAL),
    VARROCK_WEST_3(new Area(new int[][]{
            {3133, 3415},
            {3146, 3415},
            {3152, 3395},
            {3140, 3391}
    }), false, 8, TreeType.NORMAL, TreeType.OAK),
    VARROCK_WEST_4(new Area(new int[][]{
            {3149, 3417},
            {3147, 3443},
            {3124, 3447},
            {3117, 3436},
            {3116, 3418}
    }), false, 12, TreeType.NORMAL, TreeType.OAK),
    VARROCK_WEST_5(new Area(new int[][]{
            {3148, 3466},
            {3173, 3465},
            {3173, 3446},
            {3148, 3445}
    }), false, 6, TreeType.NORMAL),
    VARROCK_WEST_6(new Area(new int[][]{
            {3209, 3377},
            {3216, 3359},
            {3201, 3351},
            {3190, 3366},
            {3197, 3374}
    }), false, 6, TreeType.NORMAL, TreeType.OAK),
    VARROCK_SOUTH_1(new Area(new int[][]{
            {3240, 3373},
            {3241, 3355},
            {3276, 3357},
            {3276, 3375}
    }), false, 16, TreeType.NORMAL, TreeType.OAK, TreeType.YEW),
    VARROCK_SOUTH_2(new Area(new int[][]{
            {3287, 3356},
            {3288, 3333},
            {3263, 3332},
            {3270, 3357}
    }), false, 12, TreeType.NORMAL),
    VARROCK_SOUTH_3(new Area(new int[][]{
            {3311, 3355},
            {3311, 3327},
            {3285, 3328},
            {3291, 3357}
    }), false, 12, TreeType.NORMAL, TreeType.OAK),
    VARROCK_SOUTH_4(new Area(new int[][]{
            {3224, 3337},
            {3235, 3335},
            {3233, 3329},
            {3223, 3331}
    }), false, 2, TreeType.NORMAL, TreeType.OAK),
    VARROCK_EAST_1(new Area(new int[][]{
            {3274, 3427},
            {3274, 3406},
            {3286, 3406},
            {3285, 3426}
    }), false, 6, TreeType.NORMAL, TreeType.OAK),
    VARROCK_EAST_2(new Area(new int[][]{
            {3270, 3457},
            {3285, 3457},
            {3285, 3427},
            {3271, 3427}
    }), false, 8, TreeType.NORMAL, TreeType.OAK),
    VARROCK_EAST_3(new Area(new int[][]{
            {3263, 3486},
            {3286, 3486},
            {3288, 3495},
            {3301, 3494},
            {3301, 3481},
            {3296, 3472},
            {3290, 3463},
            {3269, 3459},
            {3261, 3466}
    }), false, 18, TreeType.NORMAL, TreeType.OAK, TreeType.YEW),
    VARROCK_EAST_4(new Area(new int[][]{
            {3288, 3458},
            {3315, 3464},
            {3312, 3474},
            {3312, 3480},
            {3310, 3486},
            {3316, 3488},
            {3314, 3495},
            {3301, 3483}
    }), false, 18, TreeType.NORMAL, TreeType.OAK, TreeType.YEW),
    VARROCK_EAST_5(new Area(new int[][]{
            {3263, 3486},
            {3276, 3487},
            {3278, 3521},
            {3243, 3519},
            {3252, 3496}
    }), false, 15, TreeType.NORMAL, TreeType.OAK, TreeType.YEW),
    VARROCK_EAST_6(new Area(new int[][]{
            {3244, 3520},
            {3244, 3501},
            {3227, 3507},
            {3198, 3507},
            {3191, 3518},
            {3196, 3520}
    }), false, 12, TreeType.NORMAL, TreeType.OAK),
    VARROCK_PALACE_1(new Area(new int[][]{
            {3246, 3475},
            {3252, 3475},
            {3252, 3470},
            {3246, 3470}
    }), false, 20, TreeType.YEW),
    VARROCK_PALACE_2(new Area(new int[][]{
            {3225, 3507},
            {3226, 3495},
            {3202, 3497},
            {3201, 3506}
    }), false, 10, TreeType.YEW),
    EDGEVILLE_1(new Area(new int[][]{
            {3131, 3515},
            {3130, 3510},
            {3122, 3497},
            {3116, 3494},
            {3108, 3503},
            {3112, 3508},
            {3120, 3513}
    }), false, 6, TreeType.NORMAL),
    EDGEVILLE_2(new Area(new int[][]{
            {3083, 3483},
            {3090, 3483},
            {3091, 3465},
            {3084, 3467}
    }), false, 12, TreeType.YEW),
    EDGEVILLE_3(new Area(new int[][]{
            {3070, 3490},
            {3077, 3489},
            {3080, 3464},
            {3093, 3460},
            {3092, 3448},
            {3070, 3452}
    }), false, 12, TreeType.NORMAL),
    BARBARIAN_VILLAGE_1(new Area(new int[][]{
            {3067, 3445},
            {3066, 3416},
            {3039, 3414},
            {3033, 3444}
    }), false, 15, TreeType.EVERGREEN),
    BARBARIAN_VILLAGE_2(new Area(new int[][]{
            {3068, 3443},
            {3032, 3441},
            {3039, 3477},
            {3064, 3477}
    }), false, 15, TreeType.EVERGREEN),

    DWARVEN_MINE(new Area(new int[][]{
            {2957, 3456},
            {2977, 3462},
            {2993, 3434},
            {2982, 3426},
            {2966, 3439}
    }), false, 15, TreeType.EVERGREEN),
    FALADOR_NORTH_1(new Area(new int[][]{
            {2947, 3439},
            {2964, 3438},
            {2980, 3423},
            {2972, 3413},
            {2950, 3422}
    }), false, 14, TreeType.NORMAL, TreeType.EVERGREEN),
    FALADOR_NORTH_2(new Area(new int[][]{
            {2947, 3425},
            {2964, 3406},
            {2958, 3397},
            {2941, 3396}
    }), false, 14, TreeType.NORMAL, TreeType.OAK),
    FALADOR_NORTH_3(new Area(new int[][]{
            {2985, 3423},
            {2985, 3411},
            {3014, 3411},
            {3014, 3426}
    }), false, 13, TreeType.NORMAL, TreeType.EVERGREEN, TreeType.OAK),
    FALADOR_NORTH_4(new Area(new int[][]{
            {3009, 3421},
            {3009, 3392},
            {3042, 3389},
            {3041, 3408}
    }), false, 15, TreeType.NORMAL, TreeType.OAK),
    FALADOR_1(new Area(new int[][]{
            {3008, 3369},
            {3002, 3350},
            {2993, 3356},
            {2995, 3367},
            {2982, 3376},
            {2985, 3380}
    }), false, 3, TreeType.NORMAL, TreeType.OAK),
    FALADOR_2(new Area(new int[][]{
            {3033, 3328},
            {3058, 3328},
            {3058, 3359},
            {3052, 3358},
            {3050, 3340},
            {3041, 3342},
            {3034, 3341}
    }), false, 5, TreeType.NORMAL, TreeType.OAK),
    CRAFTING_GUILD_1(new Area(new int[][]{
            {2928, 3319},
            {2926, 3290},
            {2912, 3291},
            {2908, 3304},
            {2909, 3319}
    }), false, 10, TreeType.NORMAL, TreeType.OAK, TreeType.WILLOW),
    CRAFTING_GUILD_2(new Area(new int[][]{
            {2927, 3317},
            {2927, 3292},
            {2944, 3288},
            {2942, 3309}
    }), false, 8, TreeType.NORMAL, TreeType.OAK),
    CRAFTING_GUILD_3(new Area(new int[][]{
            {2947, 3278},
            {2946, 3259},
            {2941, 3256},
            {2923, 3258},
            {2924, 3263},
            {2935, 3265}
    }), false, 8, TreeType.NORMAL, TreeType.OAK),
    RIMMINGTON_NORTH_1(new Area(new int[][]{
            {2944, 3236},
            {2931, 3215},
            {2924, 3216},
            {2917, 3238}
    }), false, 14, TreeType.NORMAL, TreeType.OAK, TreeType.YEW),
    RIMMINGTON_NORTH_2(new Area(new int[][]{
            {2942, 3215},
            {2957, 3221},
            {2956, 3241},
            {2945, 3238},
            {2939, 3224}
    }), false, 10, TreeType.NORMAL, TreeType.OAK),
    RIMMINGTON_NORTH_3(new Area(new int[][]{
            {2969, 3228},
            {2965, 3221},
            {2956, 3224},
            {2957, 3238},
            {2961, 3250},
            {2966, 3248},
            {2964, 3234}
    }), false, 8, TreeType.NORMAL, TreeType.OAK),
    RIMMINGTON_SOUTH_1(new Area(new int[][]{
            {2978, 3212},
            {2979, 3193},
            {2968, 3187},
            {2953, 3192},
            {2952, 3198},
            {2964, 3200},
            {2972, 3207},
            {2971, 3211}
    }), false, 14, TreeType.NORMAL, TreeType.OAK, TreeType.WILLOW),
    RIMMINGTON_SOUTH_2(new Area(new int[][]{
            {2977, 3211},
            {2977, 3196},
            {3003, 3199},
            {3003, 3206},
            {2986, 3211}
    }), false, 8, TreeType.NORMAL, TreeType.OAK),
    RIMMINGTON_SOUTH_3(new Area(new int[][]{
            {2981, 3197},
            {2998, 3198},
            {2992, 3180},
            {2984, 3182}
    }), false, 14, TreeType.NORMAL, TreeType.WILLOW),
    MUDSKIPPER_1(new Area(new int[][]{
            {3015, 3177},
            {3015, 3158},
            {3004, 3153},
            {2993, 3165},
            {2992, 3171}
    }), false, 14, TreeType.NORMAL, TreeType.OAK, TreeType.WILLOW),
    MUDSKIPPER_2(new Area(new int[][]{
            {3015, 3177},
            {3015, 3160},
            {3031, 3168},
            {3031, 3180},
            {3024, 3188},
            {3020, 3177}
    }), false, 14, TreeType.NORMAL, TreeType.OAK, TreeType.WILLOW),
    PORT_SARIM_WEST_1(new Area(new int[][]{
            {3013, 3218},
            {3013, 3210},
            {3004, 3205},
            {2987, 3212},
            {2989, 3219},
            {2995, 3221},
            {3000, 3222}
    }), false, 8, TreeType.NORMAL, TreeType.OAK),
    PORT_SARIM_WEST_2(new Area(new int[][]{
            {3010, 3237},
            {3010, 3218},
            {2992, 3223},
            {2989, 3232},
            {2996, 3237}
    }), false, 8, TreeType.NORMAL),
    PORT_SARIM_WEST_3(new Area(new int[][]{
            {3009, 3257},
            {3015, 3251},
            {2991, 3237},
            {2987, 3247},
            {2977, 3253},
            {2977, 3262},
            {2995, 3264},
            {3002, 3260}
    }), false, 18, TreeType.NORMAL, TreeType.OAK),
    FALADOR_SOUTH_1(new Area(new int[][]{
            {2947, 3286},
            {2948, 3263},
            {2961, 3257},
            {2979, 3275},
            {2967, 3284}
    }), false, 8, TreeType.NORMAL),
    FALADOR_SOUTH_2(new Area(new int[][]{
            {2984, 3311},
            {2982, 3275},
            {2968, 3290},
            {2956, 3292},
            {2943, 3308},
            {2950, 3309}
    }), false, 20, TreeType.NORMAL, TreeType.OAK),
    FALADOR_SOUTH_3(new Area(new int[][]{
            {2985, 3308},
            {2983, 3276},
            {3006, 3278},
            {3005, 3320},
            {2994, 3315}
    }), false, 20, TreeType.NORMAL, TreeType.OAK, TreeType.YEW),
    FALADOR_SOUTH_4(new Area(new int[][]{
            {3034, 3328},
            {3034, 3314},
            {3022, 3314},
            {3019, 3312},
            {3014, 3312},
            {3013, 3298},
            {3006, 3298},
            {3007, 3317},
            {3011, 3323},
            {3019, 3326}
    }), false, 15, TreeType.NORMAL, TreeType.OAK, TreeType.YEW),
    FALADOR_SOUTH_5(new Area(new int[][]{
            {3035, 3328},
            {3035, 3313},
            {3068, 3313},
            {3063, 3326},
            {3055, 3327}
    }), false, 15, TreeType.NORMAL, TreeType.OAK, TreeType.YEW),
    PORT_SARIM_NORTH_1(new Area(new int[][]{
            {3007, 3262},
            {3020, 3264},
            {3033, 3275},
            {3028, 3282},
            {3012, 3282}
    }), false, 10, TreeType.NORMAL, TreeType.OAK),
    PORT_SARIM_NORTH_2(new Area(new int[][]{
            {3035, 3281},
            {3030, 3267},
            {3035, 3255},
            {3044, 3259},
            {3045, 3274},
            {3043, 3279}
    }), false, 10, TreeType.NORMAL, TreeType.OAK),
    PORT_SARIM_NORTH_3(new Area(new int[][]{
            {3044, 3259},
            {3045, 3272},
            {3044, 3279},
            {3051, 3280},
            {3058, 3274},
            {3062, 3273},
            {3056, 3260}
    }), false, 15, TreeType.NORMAL, TreeType.OAK, TreeType.YEW),
    PORT_SARIM_NORTH_4(new Area(new int[][]{
            {3064, 3256},
            {3064, 3249},
            {3056, 3249},
            {3055, 3255}
    }), false, 14, TreeType.WILLOW),
    DRAYNOR_VILLAGE_NORTH_1(new Area(new int[][]{
            {3086, 3277},
            {3088, 3263},
            {3075, 3262},
            {3072, 3245},
            {3066, 3245},
            {3065, 3253},
            {3068, 3262},
            {3073, 3270},
            {3074, 3275}
    }), false, 8, TreeType.NORMAL, TreeType.OAK),
    DRAYNOR_VILLAGE_NORTH_2(new Area(new int[][]{
            {3081, 3287},
            {3093, 3271},
            {3099, 3274},
            {3096, 3279},
            {3107, 3279},
            {3109, 3283},
            {3107, 3294},
            {3090, 3290}
    }), false, 8, TreeType.NORMAL, TreeType.OAK),
    DRAYNOR_VILLAGE_NORTH_3(new Area(new int[][]{
            {3091, 3290},
            {3077, 3288},
            {3072, 3303},
            {3075, 3308},
            {3087, 3312},
            {3092, 3312},
            {3095, 3303},
            {3095, 3296}
    }), false, 8, TreeType.NORMAL, TreeType.OAK),
    DRAYNOR_VILLAGE_NORTH_4(new Area(new int[][]{
            {3093, 3312},
            {3098, 3294},
            {3108, 3294},
            {3112, 3311},
            {3106, 3317}
    }), false, 6, TreeType.NORMAL, TreeType.OAK),
    DRAYNOR_VILLAGE_NORTH_5(new Area(new int[][]{
            {3112, 3309},
            {3110, 3294},
            {3130, 3295},
            {3129, 3306}
    }), false, 5, TreeType.NORMAL),
    DRAYNOR_VILLAGE_NORTH_6(new Area(new int[][]{
            {3136, 3328},
            {3135, 3316},
            {3148, 3315},
            {3148, 3329}
    }), false, 5, TreeType.NORMAL, TreeType.OAK),
    DRAYNOR_VILLAGE_EAST_1(new Area(new int[][]{
            {3097, 3238},
            {3105, 3237},
            {3103, 3254},
            {3097, 3255}
    }), false, 4, TreeType.NORMAL, TreeType.OAK),
    DRAYNOR_VILLAGE_EAST_2(new Area(new int[][]{
            {3113, 3266},
            {3126, 3266},
            {3126, 3256},
            {3111, 3249},
            {3103, 3256}
    }), false, 8, TreeType.NORMAL, TreeType.OAK),
    DRAYNOR_VILLAGE_SOUTH_1(new Area(new int[][]{
            {3088, 3246},
            {3088, 3238},
            {3093, 3228},
            {3088, 3223},
            {3079, 3236},
            {3082, 3245}
    }), false, 15, TreeType.WILLOW),
    DRAYNOR_VILLAGE_SOUTH_2(new Area(new int[][]{
            {3123, 3232},
            {3118, 3209},
            {3101, 3219},
            {3102, 3235}
    }), false, 12, TreeType.NORMAL, TreeType.OAK),
    DRAYNOR_VILLAGE_SOUTH_3(new Area(new int[][]{
            {3121, 3231},
            {3118, 3212},
            {3125, 3204},
            {3134, 3202},
            {3142, 3211},
            {3134, 3225}
    }), false, 12, TreeType.NORMAL, TreeType.OAK),
    LUMBRIDGE_WEST_1(new Area(new int[][]{
            {3136, 3259},
            {3157, 3260},
            {3160, 3250},
            {3156, 3233},
            {3134, 3229}
    }), false, 20, TreeType.NORMAL, TreeType.OAK, TreeType.YEW),
    LUMBRIDGE_WEST_2(new Area(new int[][]{
            {3134, 3226},
            {3142, 3212},
            {3158, 3212},
            {3155, 3233},
            {3150, 3234}
    }), false, 20, TreeType.NORMAL, TreeType.OAK, TreeType.YEW),
    LUMBRIDGE_WEST_3(new Area(new int[][]{
            {3158, 3232},
            {3156, 3209},
            {3161, 3206},
            {3176, 3206},
            {3173, 3229},
            {3170, 3231}
    }), false, 20, TreeType.NORMAL, TreeType.OAK, TreeType.YEW),
    LUMBRIDGE_WEST_4(new Area(new int[][]{
            {3177, 3232},
            {3176, 3206},
            {3200, 3205},
            {3199, 3231}
    }), false, 20, TreeType.NORMAL, TreeType.OAK, TreeType.YEW),
    LUMBRIDGE_WEST_5(new Area(new int[][]{
            {3206, 3252},
            {3206, 3236},
            {3178, 3227},
            {3164, 3232},
            {3171, 3238},
            {3191, 3244},
            {3193, 3248}
    }), false, 10, TreeType.NORMAL, TreeType.OAK),
    LUMBRIDGE_WEST_6(new Area(new int[][]{
            {3196, 3255},
            {3186, 3242},
            {3172, 3249},
            {3171, 3263},
            {3184, 3263},
            {3189, 3261}
    }), false, 5, TreeType.NORMAL, TreeType.OAK),
    LUMBRIDGE_WEST_7(new Area(new int[][]{
            {3169, 3275},
            {3169, 3263},
            {3154, 3260},
            {3153, 3266}
    }), false, 8, TreeType.NORMAL, TreeType.OAK, TreeType.WILLOW),
    LUMBRIDGE_WEST_8(new Area(new int[][]{
            {3161, 3274},
            {3175, 3273},
            {3176, 3267},
            {3182, 3269},
            {3183, 3285},
            {3164, 3287}
    }), false, 8, TreeType.NORMAL, TreeType.WILLOW),
    RIVER_LUM_1(new Area(new int[][]{
            {3178, 3341},
            {3178, 3315},
            {3156, 3318},
            {3154, 3333},
            {3158, 3341},
            {3167, 3342}
    }), false, 10, TreeType.NORMAL),
    RIVER_LUM_2(new Area(new int[][]{
            {3176, 3338},
            {3176, 3315},
            {3202, 3307},
            {3205, 3326},
            {3190, 3337}
    }), false, 10, TreeType.NORMAL, TreeType.OAK),
    RIVER_LUM_3(new Area(new int[][]{
            {3217, 3310},
            {3223, 3310},
            {3223, 3299},
            {3218, 3297}
    }), false, 15, TreeType.WILLOW),
    LUMBRIDGE_EAST_1(new Area(new int[][]{
            {3236, 3246},
            {3237, 3228},
            {3228, 3227},
            {3220, 3234},
            {3210, 3237},
            {3214, 3241},
            {3222, 3248}
    }), false, 5, TreeType.NORMAL, TreeType.WILLOW),
    LUMBRIDGE_EAST_2(new Area(new int[][]{
            {3223, 3263},
            {3219, 3254},
            {3213, 3256},
            {3212, 3265},
            {3218, 3273},
            {3227, 3273},
            {3232, 3266}
    }), false, 6, TreeType.NORMAL, TreeType.OAK),
    LUMBRIDGE_EAST_3(new Area(new int[][]{
            {3231, 3274},
            {3240, 3278},
            {3251, 3271},
            {3250, 3250},
            {3239, 3249},
            {3239, 3263}
    }), false, 6, TreeType.NORMAL, TreeType.OAK),
    LUMBRIDGE_EAST_4(new Area(new int[][]{
            {3252, 3254},
            {3265, 3254},
            {3266, 3238},
            {3254, 3230},
            {3249, 3237},
            {3253, 3244}
    }), false, 6, TreeType.NORMAL, TreeType.OAK),
    LUMBRIDGE_EAST_5(new Area(new int[][]{
            {3267, 3237},
            {3267, 3212},
            {3260, 3215},
            {3254, 3223},
            {3262, 3237}
    }), false, 6, TreeType.NORMAL, TreeType.OAK),
    LUMBRIDGE_EAST_6(new Area(new int[][]{
            {3247, 3204},
            {3253, 3204},
            {3252, 3198},
            {3247, 3199}
    }), false, 10, TreeType.YEW);


    private final Area AREA;
    private final boolean MEMBERS;
    private final int CAPACITY;
    private final TreeType TREE_TYPE[];

    ChoppingLocation(Area area, boolean members, int capacity, TreeType... tree_type) {
        this.AREA = area;
        this.MEMBERS = members;
        this.CAPACITY = capacity;
        this.TREE_TYPE = tree_type;
    }

    public Area getArea() {
        return AREA;
    }

    public boolean isMembers() {
        return MEMBERS;
    }

    public int getCapacity() {
        return CAPACITY;
    }

    public TreeType[] getTreeTypes() {
        return TREE_TYPE;
    }
    
    public boolean containsTreeType(TreeType t)
    {
    	for(TreeType type : TREE_TYPE)
    		if(type == t)
    			return true;
    	
    	return false;
    }

}
